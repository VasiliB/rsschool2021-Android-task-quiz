package com.rsschool.quiz.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.*
import com.rsschool.quiz.view.QuizViewPagerAdapter.QuizViewHolder
import com.rsschool.quiz.R
import com.rsschool.quiz.model.Questions


class QuizViewPagerAdapter(private val viewPager2: ViewPager2) :
    ListAdapter<Questions, QuizViewHolder>(DiffCallback) {


    class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val toolbar: Toolbar = itemView.findViewById(R.id.detail_toolbar)
//        private val appBarLayout: AppBarLayout = itemView.findViewById(R.id.detail_appbar)
//        val collapsingToolbar: CollapsingToolbarLayout =
//            itemView.findViewById(R.id.detail_collapsing_toolbar)
        private val question: TextView = itemView.findViewById(R.id.question)
        private val option_one: TextView = itemView.findViewById(R.id.option_one)
        private val option_two: TextView = itemView.findViewById(R.id.option_two)
        private val option_three: TextView = itemView.findViewById(R.id.option_three)
        private val option_four: TextView = itemView.findViewById(R.id.option_four)
        private val option_five: TextView = itemView.findViewById(R.id.option_five)
//        val fab: FloatingActionButton = itemView.findViewById(R.id.fab)

        fun bind(questionArgs: Questions) {
            question.text = questionArgs.question
            option_one.text = questionArgs.option_1
            option_two.text = questionArgs.option_2
            option_three.text = questionArgs.option_3
            option_four.text = questionArgs.option_4
            option_five.text = questionArgs.option_5
//            appBarLayout.addOnOffsetChangedListener(appBarLayoutListener(questionArgs))
//            toolbar.setNavigationOnClickListener { v ->
//                Navigation.findNavController(v).navigateUp()
//            }
        }

//        private fun appBarLayoutListener(sportsArgs: Questions): AppBarLayout.OnOffsetChangedListener =
//            object : AppBarLayout.OnOffsetChangedListener {
//                var isShow = false
//                var scrollRange = -1
//                override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
//                    if (scrollRange == -1) {
//                        scrollRange = appBarLayout.totalScrollRange
//                    }
//                    if (scrollRange + verticalOffset == 0) {
//                        // Show title when completely collapsed.
//                        collapsingToolbar.title = sportsArgs.title
//                        isShow = true
//                    } else if (isShow) {
//                        // Hide title when collapsedToolBar is completely visible using empty string.
//                        collapsingToolbar.title = ""
//                        isShow = false
//                    }
//                }
//            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuizViewHolder {
        return QuizViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.question_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        val sportsArgs: Questions = getItem(position)
        holder.bind(sportsArgs)

        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//
//                when (state) {
//                    SCROLL_STATE_DRAGGING -> {
//                        holder.toolbar.navigationIcon = null
//                        holder.fab.visibility = View.INVISIBLE
//                    }
//                    SCROLL_STATE_IDLE -> {
//                        holder.toolbar.setNavigationIcon(R.drawable.ic_up_button)
//                        holder.fab.visibility = View.VISIBLE
//                    }
//                    SCROLL_STATE_SETTLING -> {
//                        holder.toolbar.navigationIcon = null
//                        holder.fab.visibility = View.INVISIBLE
//                    }
//                }
//            }
        })
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Questions>() {
        override fun areItemsTheSame(oldItem: Questions, newItem: Questions): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Questions, newItem: Questions): Boolean {
            return oldItem.question == newItem.question
        }
    }
}
