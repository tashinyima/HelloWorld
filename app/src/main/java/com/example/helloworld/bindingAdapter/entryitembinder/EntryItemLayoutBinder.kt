package com.example.helloworld.bindingAdapter.entryitembinder

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.core.os.persistableBundleOf
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.example.helloworld.R
import com.example.helloworld.entries.model.entries.Entry
import com.example.helloworld.entries.view.EntryFragmentDirections
import com.example.helloworld.utils.loadImage
import com.google.android.material.card.MaterialCardView

class EntryItemLayoutBinder {

    companion object {
        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imgUrl: String) {
            imageView.loadImage(imgUrl)

        }

        @BindingAdapter("dd")
        @JvmStatic
        fun setNumberofLikes(textView: TextView, likes: Int) {
            textView.text = likes.toString()
        }

        @BindingAdapter("onEntryItemClickListener")
        @JvmStatic
        fun onEntryItemClickListener(cardView: MaterialCardView, entry: Entry) {
            cardView.setOnClickListener {

                val result = EntryFragmentDirections.gotoentryDetailFragment(entry)
                cardView.findNavController().navigate(result)
            }
        }


    }
}