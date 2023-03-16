package com.example.mycreamwallpaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class DiscoverRvAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_TITLE = 0
        val TYPE_LIST = 1
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleIcon: ImageView = view.findViewById(R.id.title_icon_discover_rv_item)
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
                val holderContext = holder.itemView.context
                when (position) {
                    0 -> {
                        newHolder.titleContent.text = holderContext.getString(R.string.hot)
                        newHolder.titleIcon.setImageResource(R.drawable.ic_hot)
                    }
                    2 -> {
                        newHolder.titleContent.text = holderContext.getString(R.string.avatar)
                        newHolder.titleIcon.setImageResource(R.mipmap.avatar)
                    }
                    4 -> {
                        newHolder.titleContent.text = holderContext.getString(R.string.wallpaper)
                        newHolder.titleIcon.setImageResource(R.drawable.ic_wallpaper)
                    }
                    6 -> {
                        newHolder.titleContent.text = holderContext.getString(R.string.background)
                        newHolder.titleIcon.setImageResource(R.drawable.ic_background)
                    }
                    else -> {
                        newHolder.titleContent.text = holderContext.getString(R.string.meme)
                        newHolder.titleIcon.setImageResource(R.drawable.ic_meme)
                    }
                }
            }
            else -> {
                val newHold = holder as ListViewHolder
                newHold.recyclerView2.adapter = DiscoverRv2Adapter()
                newHold.recyclerView2.layoutManager =
                    GridLayoutManager(holder.recyclerView2.context, 3)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = position % 2
}