package com.example.electronicgadgets

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val productId = intent.getStringExtra("productId") ?: ""

        val product = ProductRepository.products.find { it.productId == productId }

        product?.let {
            val productImageView = findViewById<ImageView>(R.id.productImageView)
            val productNameTextView = findViewById<TextView>(R.id.productNameTextView)
            val productDescriptionTextView = findViewById<TextView>(R.id.productDescriptionTextView)
            val productCostTextView = findViewById<TextView>(R.id.productCostTextView)
            val imageName = it.imageSource
            val resourceId = resources.getIdentifier(imageName, "drawable", packageName)
            productImageView.setImageResource(resourceId)

            productNameTextView.text = it.productName
            productDescriptionTextView.text = it.productDescription
            productCostTextView.text = "$${it.cost}"
        }

        val homeButton = findViewById<Button>(R.id.homeButton)
        homeButton.setOnClickListener {
            onBackPressed()
        }
    }
}