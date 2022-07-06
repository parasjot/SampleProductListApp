package com.example.sampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_product_item.view.*


class RvProductListAdapter(list: List<Product>) : RecyclerView.Adapter<ProductListViewHolder>() {
    private var productList : List<Product> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_product_item,
                    parent,
                    false
                )
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val item = productList[position]
        holder.itemView.title.text = item.title
        holder.itemView.tv_quantity.text = item.quantity
        holder.itemView.tv_price.text = item.original_price
        Glide.with(holder.itemView).load(item.image_url).into(holder.itemView.iv_product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}