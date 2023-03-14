package com.example.mycreamwallpaper.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class DeviceUtils {
    companion object {
        // usage -> https://www.jianshu.com/p/e0085b03a145
        @JvmStatic
        fun getScreenParam(mContext: Context, type: Int): Int {
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            val width = dm.widthPixels // 屏幕宽度（像素）
            val height = dm.heightPixels // 屏幕高度（像素）
            val density = dm.density // 屏幕密度（0.75 / 1.0 / 1.5）
            val screenWidth = (width / density).toInt() // 屏幕宽度(dp)
            val screenHeight = (height / density).toInt() // 屏幕高度(dp)
            return when (type) {
                0 -> screenWidth
                1 -> screenHeight
                else -> 0
            }
        }
    }
}