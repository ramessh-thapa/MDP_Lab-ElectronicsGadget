package com.example.electronicgadgets

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val viewCartButton = findViewById<Button>(R.id.viewCartButton)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = ProductAdapter(ProductRepository.products) { product ->
            Toast.makeText(this, "Added ${product.productName} to cart", Toast.LENGTH_SHORT).show()
            product.isSelected = true
        }
        recyclerView.adapter = adapter

        viewCartButton.setOnClickListener {
            val cartItems = ProductRepository.products.filter { it.isSelected }
            val cartItemNames = cartItems.joinToString(", ") { it.productName }
            Toast.makeText(this, "Cart items: $cartItemNames", Toast.LENGTH_LONG).show()
        }
    }
}

data class Product(val productId: String, val imageSource:String, val productName: String, val productDescription: String, val cost: Double, val logo:String, var isSelected: Boolean = false)

