package com.example.mycreamwallpaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mycreamwallpaper.R

class MyRvFavouriteRvAdapter(): RecyclerView.Adapter<ViewHolder>() {
    companion object {
        val TYPE_ITEM = 0
        val TYPE_MORE = 1
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_my_rv_favourite_rv)
        val textView: TextView = view.findViewById(R.id.text_my_rv_favourite_rv)
    }

    class MoreViewHolder(view: View) :RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = when(viewType) {
        TYPE_ITEM -> {
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_my_rv_favourites_item, parent, false))
        }
        else -> {
            MoreViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_my_rv_favourites_more, parent, false))
        }
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            TYPE_ITEM -> {
                (holder as ItemViewHolder).textView.text = (position + 1).toString()
            }
            else -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int = when {
        (position <= 3) -> {
            TYPE_ITEM
        }
        else -> {
            TYPE_MORE
        }
    }
}