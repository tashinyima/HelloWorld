package com.example.helloworld.entries

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.entries.model.Entry

class EntriesAdapter(private val entries: ArrayList<Entry>) :
    RecyclerView.Adapter<EntriesAdapter.EntriesVH>() {
    // dont assign with val coz it can be reassign.
   var onItemClick: ((Entry)->Unit)? = null

    fun updateEntries(newEntries: List<Entry>) {
        entries.clear()
        entries.addAll(newEntries)
        notifyDataSetChanged()

    }

    inner class EntriesVH(view :View) : RecyclerView.ViewHolder(view) {

        var itemApiTitle: TextView
        var itemDes: TextView


        init {

            itemApiTitle = view.findViewById(R.id.tv_api)
            itemDes =    view.findViewById(R.id.txt_description)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntriesVH {

        val binding = LayoutInflater.from(parent.context).inflate(R.layout.entry_item_view, parent, false)

        return EntriesVH(binding.rootView)

    }

    override fun onBindViewHolder(holder: EntriesVH, position: Int) {
        holder.itemApiTitle.text = entries[position].api
        holder.itemDes.text = entries[position].description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(entries[position])
        }


    }

    override fun getItemCount(): Int {
        return entries.size
    }
}