package com.example.mycreamwallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.sql.Time
import kotlin.random.Random

class HomeRvAdapter(var picList: ArrayList<Pic>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_CATEGORY = 1
        val TYPE_ITEM = 2
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val catePic: ImageView = view.findViewById(R.id.cate_pic)
        val cateName: TextView = view.findViewById(R.id.cate_name)
        val cateView: ConstraintLayout = view.findViewById(R.id.item_home_rv_cate)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wallpaperPic: ImageView = view.findViewById(R.id.wallpaper_home_rv_item)
        val wallpaperContent: TextView = view.findViewById(R.id.wallpaper_home_rv_item_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_CATEGORY ->
                CategoryViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_home_rv_category, parent, false)
                )
            else ->
                ItemViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_home_rv_item, parent, false)
                )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when {
        position == 0 -> {
            val newHolder = holder as CategoryViewHolder
            newHolder.cateName.text = "category"
            newHolder.catePic.setImageResource(R.mipmap.category)
            newHolder.cateView.setOnClickListener {
                Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
            }
        }
        position == 1 -> {
            val newHolder = holder as CategoryViewHolder
                newHolder.cateName.text = "avatar"
                newHolder.catePic.setImageResource(R.mipmap.avatar)
                newHolder.cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
        }
        position == 2 -> {
            val newHolder = holder as CategoryViewHolder
                newHolder.cateName.text = "dynamic"
                newHolder.catePic.setImageResource(R.mipmap.dynamic)
                newHolder.cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
        }
        position == 3 -> {
            val newHolder = holder as CategoryViewHolder
                newHolder.cateName.text = "background"
                newHolder.catePic.setImageResource(R.mipmap.background)
                newHolder.cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
        }
        else -> {
            val newHolder = holder as ItemViewHolder
//                newHolder.wallpaperPic.setImageResource()
            val sb: StringBuilder = StringBuilder()
            for (i in 0..(1..5).random()) {
                sb.append("it's wallpaper content.")
            }
            newHolder.wallpaperPic.layoutParams.height = (500..800).random()
            newHolder.wallpaperContent.text = sb.toString()
        }
    }

    override fun getItemCount(): Int = 4 + picList.size

    override fun getItemViewType(position: Int): Int =
        if (position <= 3) TYPE_CATEGORY else TYPE_ITEM
}