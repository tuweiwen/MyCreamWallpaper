package com.example.mycreamwallpaper.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

class DeviceUtils {
    companion object {
        const val SCREEN_WIDTH_DP = 0
        const val SCREEN_HEIGHT_DP = 1
        const val SCREEN_WIDTH_PX = 2
        const val SCREEN_HEIGHT_PX = 3

        // usage -> https://www.jianshu.com/p/e0085b03a145
        @JvmStatic
        fun getScreenParam(mContext: Context, type: Int): Int {
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            val width = dm.widthPixels // 屏幕宽度(px)
            val height = dm.heightPixels // 屏幕高度(px)
            val density = dm.density // 屏幕密度（0.75 / 1.0 / 1.5）
            val screenWidth = (width / density).toInt() // 屏幕宽度(dp)
            val screenHeight = (height / density).toInt() // 屏幕高度(dp)
            return when (type) {
                SCREEN_WIDTH_DP -> screenWidth
                SCREEN_HEIGHT_DP -> screenHeight
                SCREEN_WIDTH_PX -> width
                SCREEN_HEIGHT_PX -> height
                else -> 0
            }
        }

        @JvmStatic
        fun getPxFromDp(mContext: Context, dp: Int): Int {
            val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            wm.defaultDisplay.getMetrics(dm)
            return (dm.density * dp).toInt()
        }
    }
}