package com.example.helloworld.multi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MultiplicationViewModel @Inject constructor(val multi : Multiplication): ViewModel() {

    val multiLiveData = MutableLiveData<String>()

    fun multiply(name: String ,age :Int) {

        val result = multi.multiplication(name,age)
        multiLiveData.postValue(result)
    }


}