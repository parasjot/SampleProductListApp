package com.example.sampleapp

import android.content.Context
import com.google.gson.Gson

object ParsingUtils {

    fun getProductList(context: Context) : List<Product> {
        var gson = Gson()
        return gson.fromJson(parseJson(context), ProductList::class.java).items.product_list
    }
    fun parseJson(context: Context): String {
        return context.resources.openRawResource(R.raw.product_list).bufferedReader().use { it.readText() }
    }
}