package com.example.helloworld.post.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.post.model.postmodel.JsonPosts
import com.example.helloworld.post.model.postmodel.JsonPostsItem
import com.example.helloworld.utils.loadImage

class PostAdapter(private val jsonPosts: JsonPosts) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {


    val dummy_uri =
        "https://cms-tc.pbskids.org/parents/expert-tips-and-advice/how-to-teach-frustration-tolerance-to-kids-hero.jpg"

    fun updatePosts(newPost: List<JsonPostsItem>) {
        jsonPosts.clear()
        jsonPosts.addAll(newPost)
        notifyDataSetChanged()
    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDes: TextView

        init {
            itemImage = view.findViewById(R.id.myImageView)
            itemTitle = view.findViewById(R.id.txt_title)
            itemDes = view.findViewById(R.id.txt_des)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.text = jsonPosts[position].title
        holder.itemDes.text = jsonPosts[position].id.toString()
        holder.itemImage.loadImage(jsonPosts[position].url)

        Log.i("ImageView", jsonPosts[position].url)
        holder.itemImage.loadImage(dummy_uri)


    }

    override fun getItemCount(): Int {
        return jsonPosts.size
    }
}