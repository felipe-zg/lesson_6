package com.example.walmart_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart_app.Models.Product
import com.google.android.material.imageview.ShapeableImageView

class ProductsAdapter(private val productsList: ArrayList<Product>): RecyclerView.Adapter<ProductsAdapter.ProductsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProductsHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        val currentItem = productsList[position]
        holder.productImage.setImageResource(currentItem.image)
        holder.heading.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    class ProductsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val productImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading: TextView = itemView.findViewById(R.id.heading)
    }
}