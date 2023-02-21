package com.example.mycreamwallpaper.main.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class DiscoverRvAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_LIST = 1
        val TYPE_TITLE = 0
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleContent: TextView = view.findViewById(R.id.title_content_discover_rv_item)
    }

    class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView2: RecyclerView = view.findViewById(R.id.rv2_discover_rv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_TITLE -> TitleViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_discover_rv_title, parent, false)
            )
            else -> ListViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_discover_rv_list, parent, false)
            )
        }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TITLE -> {
                val newHolder = holder as TitleViewHolder
                newHolder.titleContent.text = when (position) {
                    0 -> "hot"
                    2 -> "avatar"
                    4 -> "wallpaper"
                    6 -> "background"
                    else -> "meme"
                }
            }
            else -> {
                val newHold = holder as ListViewHolder

            }
        }
    }

    override fun getItemViewType(position: Int): Int = position % 2
}