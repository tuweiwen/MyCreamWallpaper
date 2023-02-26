package com.example.mycreamwallpaper.main.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycreamwallpaper.R

class MyRvAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_WIDGET = 0
        val TYPE_FAVOURITE = 1
        val TYPE_CREATE = 2
        val TYPE_TOOLS = 3
    }

    class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_item_my_rv_widget)
    }

    class FavouriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_item_my_rv_favourite)
    }

    class CreateViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ToolsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_item_my_rv_tools)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_WIDGET -> WidgetViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_my_rv_widget, parent, false)
            )
            TYPE_FAVOURITE -> FavouriteViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_my_rv_favourite, parent, false)
            )
            TYPE_CREATE -> CreateViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_my_rv_create, parent, false)
            )
            else -> ToolsViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_my_rv_tools, parent, false)
            )
        }

    override fun getItemViewType(position: Int): Int = when (position) {
        0 -> TYPE_WIDGET
        1 -> TYPE_FAVOURITE
        2 -> TYPE_CREATE
        else -> TYPE_TOOLS
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            TYPE_WIDGET -> {

            }
            TYPE_FAVOURITE -> {
                val rv = (holder as FavouriteViewHolder).recyclerView
                rv.layoutManager = GridLayoutManager(holder.itemView.context, 5, GridLayoutManager.VERTICAL, false)
                rv.adapter = MyRvFavouriteRvAdapter()
            }
            TYPE_CREATE -> {

            }
            else -> {
                val rv = (holder as ToolsViewHolder).recyclerView
                rv.layoutManager = GridLayoutManager(holder.itemView.context, 4, GridLayoutManager.VERTICAL, false)
                rv.adapter = MyRvToolsRvAdapter()
            }
        }
    }
}