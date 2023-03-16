package com.example.mycreamwallpaper.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mycreamwallpaper.R
import com.example.mycreamwallpaper.activity.PicsDetailActivity
import com.example.mycreamwallpaper.bean.Pic
import com.example.mycreamwallpaper.utils.DeviceUtils

class HomeRvAdapter(var picList: ArrayList<Pic>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val TYPE_CATEGORY = 1
        val TYPE_ITEM = 2
        val TYPE_TITLE = 3
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val catePic: ImageView = view.findViewById(R.id.cate_pic_home_rv_item)
        val cateName: TextView = view.findViewById(R.id.cate_name_home_rv_item)
        val cateView: ConstraintLayout = view.findViewById(R.id.item_home_rv_cate)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wallpaperPic: ImageView = view.findViewById(R.id.wallpaper_home_rv_item)
        val wallpaperContent: TextView = view.findViewById(R.id.wallpaper_home_rv_item_content)
        val wallpaperView: ConstraintLayout = view.findViewById(R.id.item_home_rv_item)
    }

    class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleIcon: ImageView = view.findViewById(R.id.title_icon_home_rv_item)
        val titleContent: TextView = view.findViewById(R.id.title_name_home_rv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_CATEGORY ->
                CategoryViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_home_rv_category, parent, false)
                )
            TYPE_TITLE ->
                TitleViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_home_rv_title, parent, false)
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
            with(newHolder) {
                val layoutParams =
                    this.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.setMargins(0, DeviceUtils.getPxFromDp(this.itemView.context, 10), 0, 0)
                cateName.text = holder.itemView.context.getString(R.string.category)
                catePic.setImageResource(R.mipmap.category)
                cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
        position == 1 -> {
            val newHolder = holder as CategoryViewHolder
            with(newHolder) {
                val layoutParams =
                    this.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
                layoutParams.setMargins(0, DeviceUtils.getPxFromDp(this.itemView.context, 10), 0, 0)
                cateName.text = this.itemView.context.getString(R.string.avatar_home)
                catePic.setImageResource(R.mipmap.avatar)
                cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
        position == 2 -> {
            val newHolder = holder as CategoryViewHolder
            with(newHolder) {
                cateName.text = holder.itemView.context.getString(R.string.dynamic)
                catePic.setImageResource(R.mipmap.dynamic)
                cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
        position == 3 -> {
            val newHolder = holder as CategoryViewHolder
            with(newHolder) {
                cateName.text = holder.itemView.context.getString(R.string.background_home)
                catePic.setImageResource(R.mipmap.background)
                cateView.setOnClickListener {
                    Toast.makeText(it.context, "clicked item $position", Toast.LENGTH_SHORT).show()
                }
            }
        }
        position == 4 -> {
            val newHolder = holder as TitleViewHolder
            with(newHolder) {
                titleContent.text = holder.itemView.context.getString(R.string.hot)
            }
            (newHolder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan =
                true
        }
        else -> {
            val newHolder = holder as ItemViewHolder
//                newHolder.wallpaperPic.setImageResource()
            val sb: StringBuilder = StringBuilder()
            for (i in 0..(1..5).random()) {
                sb.append(newHolder.itemView.context.getString(R.string.pic_content_default_short))
//                sb.append("it's wallpaper content.")
            }
            with(newHolder) {
                wallpaperPic.layoutParams.height = (500..800).random()
                wallpaperContent.text = sb.toString()
//                wallpaperContent.text = holder.itemView.context.getString(R.string.pic_content_default)
                wallpaperView.setOnClickListener {
                    it.context.startActivity(Intent(it.context, PicsDetailActivity::class.java))
//                    Toast.makeText(it.context, "clicked wallpaper item ${position-5}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = 5 + picList.size

    override fun getItemViewType(position: Int): Int = when {
        position <= 3 -> TYPE_CATEGORY
        position == 4 -> TYPE_TITLE
        else -> TYPE_ITEM
    }
}

