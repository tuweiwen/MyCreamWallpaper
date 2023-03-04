package com.example.mycreamwallpaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class PicsDetailRecommendsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class RecommendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_pics_detail_rv_recommend)
        val title: TextView = view.findViewById(R.id.title_pics_detail_rv_recommend)
        val favouriteCount: TextView = view.findViewById(R.id.fav_count_pics_detail_rv_recommend)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        RecommendViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pics_detail_rv_recommends_item, parent, false)
        )

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newHolder = holder as RecommendViewHolder
        newHolder.let {
            it.title.text = "this is title"
            it.favouriteCount.text = "999"
        }
    }
}