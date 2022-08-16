package com.example.helloworld.add

import javax.inject.Inject

class AddImpl @Inject constructor(): Add {
    override fun add(first_num: Int, second_num: Int): Int {
        return first_num + second_num
    }
}