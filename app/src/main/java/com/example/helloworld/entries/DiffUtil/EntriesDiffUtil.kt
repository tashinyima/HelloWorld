package com.example.helloworld.entries.DiffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.helloworld.entries.model.entries.Entry

class EntriesDiffUtil(private val oldEntry: List<Entry>, private val newEntry: List<Entry>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldEntry.size
    }

    override fun getNewListSize(): Int {
      return  newEntry.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
   return oldEntry[oldItemPosition]===newEntry[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldEntry[oldItemPosition]==newEntry[newItemPosition]
    }
}