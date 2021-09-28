package com.rsschool.quiz.view

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.developersbreach.recyclerviewtoviewpager.viewModel.QuizViewModel
import com.developersbreach.recyclerviewtoviewpager.viewModel.QuizViewModelFactory
import com.rsschool.quiz.R
import com.rsschool.quiz.model.Questions

/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {

    private lateinit var questionArgs: Questions
    private lateinit var viewModel: QuizViewModel
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        val application: Application = requireActivity().application
        questionArgs = DetailsFragmentArgs.fromBundle(args).quizFragmentArgs
        val factory = QuizViewModelFactory(application, questionArgs)
        viewModel = ViewModelProvider(this, factory).get(QuizViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_quiz, container, false)
        viewPager2 = view.findViewById(R.id.pager)
        viewPager2.setPageTransformer(ZoomOutPageTransformer())
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.sportList.observe(viewLifecycleOwner, Observer { sportsList ->
            val detailViewPagerAdapter = QuizViewPagerAdapter(viewPager2)
            detailViewPagerAdapter.submitList(sportsList)
            viewPager2.adapter = detailViewPagerAdapter
            viewModel.selectedSport.observe(viewLifecycleOwner, Observer { selectedSport ->
                val resetPosition = selectedSport.id
                viewPager2.setCurrentItem(resetPosition, false)
            })
        })
    }

}
