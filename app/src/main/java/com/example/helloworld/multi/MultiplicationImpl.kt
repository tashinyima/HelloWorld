package com.example.helloworld.multi

import javax.inject.Inject

class MultiplicationImpl @Inject constructor() : Multiplication{
    override fun multiplication(name: String, age: Int): String {
        return "Your name is $name and this year you are $age years old"
    }

}