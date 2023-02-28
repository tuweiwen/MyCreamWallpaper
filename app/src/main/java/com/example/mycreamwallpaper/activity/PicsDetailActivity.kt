package com.example.mycreamwallpaper.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mycreamwallpaper.R

class PicsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics_detail)
        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_to_right)

        val toolbar: Toolbar = findViewById(R.id.toolbar_activity_pics_detail)
        setSupportActionBar(toolbar)
    }
}