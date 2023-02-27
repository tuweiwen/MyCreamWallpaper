package com.example.mycreamwallpaper.utils

import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView


class LinearLayoutManagerWithScrollTop : LinearLayoutManager {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun smoothScrollToPosition(recyclerView: RecyclerView, state: RecyclerView.State, position: Int) {
        val topSnappedSmoothScroller = TopSnappedSmoothScroller(recyclerView.context)
        topSnappedSmoothScroller.targetPosition = position
        startSmoothScroll(topSnappedSmoothScroller)
    }

    internal inner class TopSnappedSmoothScroller(context: Context?) : LinearSmoothScroller(context) {
        override fun computeScrollVectorForPosition(targetPosition: Int): PointF? =
            this@LinearLayoutManagerWithScrollTop.computeScrollVectorForPosition(targetPosition)

        override fun getVerticalSnapPreference(): Int = SNAP_TO_START //设置滚动位置
    }
}