package com.example.walmart_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.walmart_app.Models.Product
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        var product = Product("Brazilian chocotone - chocolate drops", 23.90, "N/A", "An amaing brazilian cake with drops of chocolate", R.drawable.food_chocotonne)
        img_product.setImageResource(product.image)
        txt_title.text = product.title
        txt_color.text = "Color: " + product.color
        txt_price.text = "Price: $" + product.price.toString()
        txt_description.text = product.description
    }
}