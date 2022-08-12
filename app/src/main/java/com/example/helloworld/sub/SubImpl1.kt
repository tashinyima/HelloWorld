package com.example.helloworld.sub

import javax.inject.Inject

class SubImpl1 @Inject constructor(): Sub {
    override fun sub(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    override fun add(n1: Int, n2: Int): Int {
        return n1 +n2
    }
}