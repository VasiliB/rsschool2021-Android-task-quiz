package com.developersbreach.recyclerviewtoviewpager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rsschool.quiz.model.Questions

class QuizViewModel(application: Application, sports: Questions): AndroidViewModel(application) {

    private val _questionsList: MutableLiveData<List<Questions>> = MutableLiveData()
    val sportList: MutableLiveData<List<Questions>>
        get() = _questionsList

    private val _selectedSport: MutableLiveData<Questions> = MutableLiveData()
    val selectedSport: MutableLiveData<Questions>
        get() = _selectedSport

    init {
        val questionsList: List<Questions> = Questions.questionsList(application.applicationContext)
        _questionsList.value = questionsList
        _selectedSport.value = sports
    }
}