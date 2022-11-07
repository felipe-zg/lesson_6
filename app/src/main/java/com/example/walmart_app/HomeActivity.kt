package com.example.walmart_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.walmart_app.Models.Product
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var clothesList = ArrayList(arrayListOf(
        Product("First product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Second product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Third product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fourth product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fifth product", 23.90, "black", "This is the first product", R.drawable.clothes),
    ))

    var foodsList = ArrayList(arrayListOf(
        Product("Lays chips", 23.90, "black", "This is the first product", R.drawable.food_chips),
        Product("Brazilian chocotone - chocolate drops", 23.90, "black", "This is the first product", R.drawable.food_chocotonne),
        Product("Barilla penne pasta", 23.90, "black", "This is the first product", R.drawable.food_pasta),
        Product("Hamburger 12 count", 23.90, "black", "This is the first product", R.drawable.food_hamburger),
        Product("Monster energy drink 4 pack", 23.90, "black", "This is the first product", R.drawable.food_energy_drink),
    ))

    var electronicsList = ArrayList(arrayListOf(
        Product("First product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Second product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Third product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fourth product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fifth product", 23.90, "black", "This is the first product", R.drawable.clothes),
    ))

    var beautyList = ArrayList(arrayListOf(
        Product("First product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Second product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Third product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fourth product", 23.90, "black", "This is the first product", R.drawable.clothes),
        Product("Fifth product", 23.90, "black", "This is the first product", R.drawable.clothes),
    ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var username = intent.getStringExtra("username")
        txt_welcome.text = "Welcome $username"
        var intent = Intent(this, ProductList::class.java)

        img_beaty.setOnClickListener {
            //intent.putExtra("products", beautyList)
            //startActivity(intent)
            var detaildIntent = Intent(this, ProductDetailActivity::class.java)
            startActivity(detaildIntent)
        }

        img_clothes.setOnClickListener {
            intent.putExtra("products", clothesList)
            startActivity(intent)
        }

        img_electronics.setOnClickListener {
            intent.putExtra("products", electronicsList)
            startActivity(intent)
        }

        img_food.setOnClickListener {
            intent.putExtra("products", foodsList)
            startActivity(intent)
        }
    }

    fun showToast(category: String) {
        Toast.makeText(this, "You chose $category category", Toast.LENGTH_SHORT).show()
    }
}