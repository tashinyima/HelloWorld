package com.example.helloworld.sub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubViewModel @Inject constructor(val sub: Sub) :ViewModel() {
    val addLiveData = MutableLiveData<Int>()
    val subLiveData = MutableLiveData<Int>()

    fun sub(number1: Int,number2: Int){
        val result =sub.sub(number1,number2)
        addLiveData.postValue(result)
    }

    fun add(n1: Int , n2:Int) {
        val result = sub.add(n1, n2)
        subLiveData.postValue(result)

    }
}