package com.example.walmart_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart_app.Models.Product

class ProductList : AppCompatActivity() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var productsList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        recyclerview = findViewById(R.id.products_recycler_view)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        productsList = arrayListOf<Product>()
        productsList = intent.getSerializableExtra("products") as ArrayList<Product>
        recyclerview.adapter = ProductsAdapter(productsList)
    }
}