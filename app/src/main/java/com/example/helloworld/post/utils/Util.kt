package com.example.helloworld.post.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.helloworld.R

fun ImageView.loadImage(uri: String?){

    Glide.with(context)
        .load(uri)
        .placeholder(R.drawable.ic_car)
        .into(this)
}