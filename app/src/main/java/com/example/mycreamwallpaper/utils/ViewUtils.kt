package com.example.mycreamwallpaper.utils

import android.app.Activity
import android.content.ContextWrapper
import android.view.View

class ViewUtils {
    companion object {
        @JvmStatic
        fun getActivityFromView(view: View?): Activity? {
            if (null != view) {
                var context = view.context
                while (context is ContextWrapper) {
                    if (context is Activity) {
                        return context
                    }
                    context = context.baseContext
                }
            }
            return null
        }
    }
}