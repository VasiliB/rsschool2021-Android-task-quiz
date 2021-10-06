package com.rsschool.quiz.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsschool.quiz.model.Questions

class QuizViewModel(application: Application, questions: Questions): AndroidViewModel(application) {

    private val _questions: MutableLiveData<List<Questions>> = MutableLiveData()
    val questionList: MutableLiveData<List<Questions>>
        get() = _questions

    private val _selectedQuestion: MutableLiveData<Questions> = MutableLiveData()
    val selectedQuestion: MutableLiveData<Questions>
        get() = _selectedQuestion

    init {
        val questionsList: List<Questions> = Questions.questionsList(application.applicationContext)
        _questions.value = questionsList
        _selectedQuestion.value = questions
    }
}

//class QuizViewModel(application: Application): AndroidViewModel(application) {
//
//    private val _questions: MutableLiveData<List<Questions>> = MutableLiveData()
//    val questionList: MutableLiveData<List<Questions>>
//        get() = _questions
//
//    init {
//        val questionsList: List<Questions> = Questions.questionsList(application.applicationContext)
//        _questions.value = questionsList
//    }
//}

//class QuizViewModel(application: Application): AndroidViewModel(application) {
//
//    private val _questions: MutableLiveData<List<Questions>> = MutableLiveData()
//    val questionList: MutableLiveData<List<Questions>>
//        get() = _questions
//
//    private val _selectedQuestion: MutableLiveData<Questions> = MutableLiveData()
//    val selectedQuestion: MutableLiveData<Questions>
//        get() = _selectedQuestion
//
//    init {
//        val questionsList: List<Questions> = Questions.questionsList(application.applicationContext)
//        _questions.value = questionsList
//        _selectedQuestion.value = questions
//    }
//}