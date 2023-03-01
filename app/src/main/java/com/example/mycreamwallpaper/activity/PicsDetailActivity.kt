package com.example.mycreamwallpaper.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mycreamwallpaper.R

class PicsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics_detail)
//        overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_to_right)

        val toolbar: Toolbar = findViewById(R.id.toolbar_activity_pics_detail)
        val favouriteBtn: ImageView = findViewById(R.id.favorite_toolbar_activity_pics_detail)
        val moreBtn: ImageView = findViewById(R.id.more_toolbar_activity_pics_detail)
//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        favouriteBtn.setOnClickListener {
            Toast.makeText(this, "you click favorite button!", Toast.LENGTH_SHORT).show()
        }
        moreBtn.setOnClickListener {
            Toast.makeText(this, "you click more button!", Toast.LENGTH_SHORT).show()
        }
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> finish()
//        }
//        return true
//    }
}