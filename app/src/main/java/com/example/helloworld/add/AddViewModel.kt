package com.example.helloworld.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(val add: Add) : ViewModel() {

    val addLiveData = MutableLiveData<Int>()

    fun add(first_num:Int,second_num:Int){
        val result = add.add(first_num,second_num)
        addLiveData.postValue(result)
    }

}