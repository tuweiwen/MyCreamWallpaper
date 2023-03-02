package com.example.mycreamwallpaper.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class PicsDetailAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_PICS = 0
        val TYPE_DESCRIBE = 1
        val TYPE_RECOMMENDS = 2
    }

    class PicsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_pics_detail_rv_pics)
    }

    class DescribeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    class RecommendsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int = when(position) {
        0 -> TYPE_PICS
        1 -> TYPE_DESCRIBE
        else -> TYPE_RECOMMENDS
    }
}