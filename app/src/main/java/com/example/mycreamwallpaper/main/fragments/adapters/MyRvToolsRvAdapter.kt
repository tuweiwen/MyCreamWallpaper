package com.example.mycreamwallpaper.main.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class MyRvToolsRvAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_my_rv_tools_rv)
        val content: TextView = view.findViewById(R.id.text_my_rv_tools_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_my_rv_tools_item, parent, false)
        )

    override fun getItemCount(): Int = 12

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newHolder = holder as ItemViewHolder
        newHolder.content.text = position.toString()
    }
}