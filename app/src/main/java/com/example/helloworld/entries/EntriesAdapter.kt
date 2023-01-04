package com.example.helloworld.entries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.databinding.EntryItemViewBinding
import com.example.helloworld.entries.model.entries.Entry

class EntriesAdapter(private var entries: ArrayList<Entry>) :
    RecyclerView.Adapter<EntriesAdapter.EntriesVH>() {
    // dont assign with val coz it can be reassign.
    var onItemClick: ((Entry) -> Unit)? = null


    fun updateEntries(newEntries: List<Entry>) {
        entries.clear()
        entries.addAll(newEntries)
        notifyDataSetChanged()

//        val entriesDiffUtil = EntriesDiffUtil(entries, newEntries)
//        val entriesDifference = DiffUtil.calculateDiff(entriesDiffUtil)
//
//        // val en = ArrayList<Entry>(newEntries)
////
//        entries = ArrayList<Entry>(newEntries)
//        entriesDifference.dispatchUpdatesTo(this)
    }

    class EntriesVH(private val binding: EntryItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(entry: Entry) {
            binding.entry = entry
            binding.executePendingBindings()
        }

        // companion object are not allowed to define in inner class
        companion object {

            fun from(parent: ViewGroup): EntriesVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EntryItemViewBinding.inflate(layoutInflater, parent, false)
                return EntriesVH(binding)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntriesVH {

//        val binding =
//            LayoutInflater.from(parent.context).inflate(R.layout.entry_item_view, parent, false)

        return EntriesVH.from(parent)

    }

    override fun onBindViewHolder(holder: EntriesVH, position: Int) {
//        holder.itemApiTitle.text = entries[position].api
//        holder.itemDes.text = entries[position].description
        // this is also another way to write.. assing to a val and then pass to fun
//        val currentEntries = entries[position]
//        holder.bind(currentEntries)
//        or

        holder.bind(entries[position])
//        holder.itemView.setOnClickListener {
//            onItemClick?.invoke(entries[position])
//        }


    }


    override fun getItemCount() = entries.size


    // or override fun getItemCount(): Int { return entries.size }   // this is normal way of writing


}