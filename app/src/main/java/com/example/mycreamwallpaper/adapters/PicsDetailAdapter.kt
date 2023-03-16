package com.example.mycreamwallpaper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class PicsDetailAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_PICS = 0
        val TYPE_DESCRIBE = 1
        val TYPE_RECOMMENDS = 2
    }

    class PicsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_pics_detail_rv_pics)
    }

    class DescribeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_item_pics_detail_rc_describe)
        val content: TextView = view.findViewById(R.id.content_item_pics_detail_rc_describe)
        val favouriteCount: TextView = view.findViewById(R.id.count_item_pics_detail_rc_describe)
        val source: TextView = view.findViewById(R.id.source_item_pics_detail_rc_describe)
    }

    class RecommendsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_item_pics_detail_rv_recommends)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_PICS -> PicsViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pics_detail_rv_pics, parent, false)
            )
            TYPE_DESCRIBE -> DescribeViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pics_detail_rv_describe, parent, false)
            )
            else -> RecommendsViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pics_detail_rv_recommends, parent, false)
            )
        }

    override fun getItemCount(): Int = 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (getItemViewType(position)) {
            TYPE_PICS -> {
                val newHolder = holder as PicsViewHolder
                newHolder.recyclerView.let {
                    it.adapter = PicsDetailPicsAdapter()
                    val layoutManager = GridLayoutManager(it.context, 6)
                    val itemCount = (it.adapter as PicsDetailPicsAdapter).itemCount
                    layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {
                            return if ((itemCount % 2) != 0) {
                                if (position < itemCount - 3) {
                                    3
                                } else {
                                    2
                                }
                            } else {
                                3
                            }
                        }
                    }
                    it.layoutManager = layoutManager
                }
            }
            TYPE_DESCRIBE -> {
                val newHolder = holder as DescribeViewHolder
                newHolder.title.text = holder.itemView.context.getString(R.string.pic_title_default)
                newHolder.content.text =
                    holder.itemView.context.getString(R.string.pic_content_default)
                newHolder.favouriteCount.text =
                    holder.itemView.context.getString(R.string.fav_count)
                newHolder.source.text = holder.itemView.context.getString(R.string.go_to_source)
            }
            else -> {
                val newHolder = holder as RecommendsViewHolder
                newHolder.recyclerView.let {
                    it.layoutManager = GridLayoutManager(it.context, 2)
                    it.adapter = PicsDetailRecommendsAdapter()
                }
            }
        }

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> TYPE_PICS
        1 -> TYPE_DESCRIBE
        else -> TYPE_RECOMMENDS
    }
}