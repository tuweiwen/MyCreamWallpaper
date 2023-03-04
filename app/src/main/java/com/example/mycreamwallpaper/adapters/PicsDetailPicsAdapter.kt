package com.example.mycreamwallpaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class PicsDetailPicsAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class PicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_pics_detail_rv_pics)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pics_detail_rv_pics_item, parent, false))

    override fun getItemCount(): Int = 11

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}