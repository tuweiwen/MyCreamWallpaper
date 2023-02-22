package com.example.mycreamwallpaper.main.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class DiscoverRv2Adapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_discover_rv2_item)
        val description: TextView = view.findViewById(R.id.description_discover_rv2_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_discover_rv_list_item, parent, false)
        )

    override fun getItemCount(): Int = 9

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newHolder = holder as ItemViewHolder
        with(newHolder) {
            this.description.text = position.toString()
        }
    }

}