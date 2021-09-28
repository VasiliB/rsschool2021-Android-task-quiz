//package com.rsschool.quiz
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentActivity
//import androidx.viewpager2.adapter.FragmentStateAdapter
//
//class QuizAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
//    override fun getItemCount(): Int = 6
//
//    override fun createFragment(position: Int): Fragment {
//        val fragment = QuizFragment()
//        fragment.arguments = Bundle().apply {
//            putInt(ARG_OBJECT, arrayListOf<data>() [position + 1])
//        }
//        return fragment
//    }
//}
//
