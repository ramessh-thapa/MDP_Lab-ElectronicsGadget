package com.example.electronicgadgets

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {
            itemView.apply {
                val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
                val smallIcon: ImageView = itemView.findViewById(R.id.smallIcon)
                val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
                val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
                val productCostTextView: TextView = itemView.findViewById(R.id.productCostTextView)
                val addButton: Button = itemView.findViewById(R.id.addButton)

                val imageName = product.imageSource
                val resourceId = context.resources.getIdentifier(imageName, "drawable", context.packageName)
                productImageView.setImageResource(resourceId)

                val logo = product.logo
                val logoResource = context.resources.getIdentifier(logo, "drawable", context.packageName)
                smallIcon.setImageResource(logoResource)

                productNameTextView.text = product.productName
                productDescriptionTextView.text = product.productDescription
                productCostTextView.text = "$${product.cost}"

                addButton.setOnClickListener {
                    onItemClick(product)
                }
                val parentLayout: LinearLayout = itemView.findViewById(R.id.parentLayout)
                parentLayout.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("productId", product.productId)
                    itemView.context.startActivity(intent)
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}
