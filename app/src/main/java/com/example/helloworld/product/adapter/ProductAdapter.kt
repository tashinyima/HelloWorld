package com.example.helloworld.product.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld.R
import com.example.helloworld.product.model.Product
import com.example.helloworld.utils.loadImage


class ProductAdapter(private val products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.MyProductVH>() {

   var onItemClick:((Product)->Unit)?=null

    fun updateProduct(newProducts: List<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }


    inner class MyProductVH(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView
        val itemDes: TextView
        val imageView: ImageView
        var itemid : TextView

        init {
            itemTitle = view.findViewById<TextView>(R.id.txt_title)
            itemDes = view.findViewById<TextView>(R.id.txt_des)
            imageView = view.findViewById<ImageView>(R.id.myImageView)
            itemid = view.findViewById(R.id.txt_id)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyProductVH(view)
    }

    override fun onBindViewHolder(holder: MyProductVH, position: Int) {

        holder.itemTitle.text = products[position].title
        holder.itemDes.text = products[position].description
        holder.imageView.loadImage(products[position].thumbnail)
        holder.itemid.text =products[position].id.toString()
        holder.itemView.setOnClickListener {
         onItemClick?.invoke(products[position])

        }



    }

    override fun getItemCount(): Int {
        return products.size
    }


}