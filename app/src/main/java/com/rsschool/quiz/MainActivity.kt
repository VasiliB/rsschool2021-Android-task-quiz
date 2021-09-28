package com.rsschool.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: QuizAdapter
    private lateinit var viewPager: ViewPager2

    private val data: List<String> = listOf(
        "R.To be, or not to be...#To be#Not to be#I don't know#It's not my problem#...that is the question",
        "Tallest skyscraper:#Shanghai Tower, Shanghai#Burj Khalifa, Dubai#Trump International Hotel, Chicago#Central Park Tower, New York#Eiffel Tower, Paris",
        "The biggest animal:#Cat#Elephant#Kitti's hog-nosed bat#Antarctic blue whale#Human",
        "What's superfluous?#Discord#Slack#Kotlin#MicrosoftTeams#Telegram",
        "The Answer to the Ultimate Question of Life, the Universe, and Everything is:#33#11#7#0#42"
    )

    private val rightAnswers: List<Int> = listOf(
        4, 1, 3, 5, 5
    )

    private val chosenOptions = mutableListOf<Int>(0, 0, 0, 0, 0)
    private var currentQuestion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openQuizFragment(data[0], chosenOptions[0], currentQuestion)

        adapter = QuizAdapter(this)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container_view, QuizFragment())
                .commit()

        }
    }

    private fun openQuizFragment(dataQuestions: String, checkedOption: Int, questionNumber: Int) {
        val firstFragment = QuizFragment.newInstance(dataQuestions, checkedOption, questionNumber)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, firstFragment)
        transaction.commit()
    }

    private fun getThemeId(questionNumber: Int): Int {
        return when (questionNumber) {
            0 -> R.style.Theme_Quiz_First
            1 -> R.style.Theme_Quiz_Second
            2 -> R.style.Theme_Quiz_Third
            3 -> R.style.Theme_Quiz_Fourth
            4 -> R.style.Theme_Quiz_Fifth
            else -> R.style.Theme_Quiz_First
        }
    }

    private fun getColorId(questionNumber: Int): Int {
        return when (questionNumber) {
            0 -> R.color.deep_orange_100_dark
            1 -> R.color.yellow_100_dark
            2 -> R.color.light_green_100_dark
            3 -> R.color.cyan_100_dark
            4 -> R.color.deep_purple_100_dark
            else -> R.color.deep_orange_100_dark
        }
    }
}

///**
// * The number of pages (wizard steps) to show in this demo.
// */
//private const val NUM_PAGES = 5
//
//class ScreenSlidePagerActivity : FragmentActivity() {
//
//    /**
//     * The pager widget, which handles animation and allows swiping horizontally to access previous
//     * and next wizard steps.
//     */
//    private lateinit var viewPager: ViewPager2
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_screen_slide)
//
//        // Instantiate a ViewPager2 and a PagerAdapter.
//        viewPager = findViewById(R.id.pager)
//
//        // The pager adapter, which provides the pages to the view pager widget.
//        val pagerAdapter = ScreenSlidePagerAdapter(this)
//        viewPager.adapter = pagerAdapter
//    }
//
//    override fun onBackPressed() {
//        if (viewPager.currentItem == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed()
//        } else {
//            // Otherwise, select the previous step.
//            viewPager.currentItem = viewPager.currentItem - 1
//        }
//    }
//
//    /**
//     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
//     * sequence.
//     */
//    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): Fragment = ScreenSlidePageFragment()
//    }
//}