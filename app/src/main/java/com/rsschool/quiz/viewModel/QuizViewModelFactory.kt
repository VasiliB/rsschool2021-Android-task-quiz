package com.rsschool.quiz.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rsschool.quiz.model.Questions

class QuizViewModelFactory(private val application: Application, private val questions: Questions) :
    ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(application, questions) as T

        }
        throw IllegalArgumentException("Cannot create instance for DetailViewModel class")
    }
}