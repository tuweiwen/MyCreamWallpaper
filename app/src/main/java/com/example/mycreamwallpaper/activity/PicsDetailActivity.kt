package com.example.mycreamwallpaper.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mycreamwallpaper.R
import com.example.mycreamwallpaper.adapters.PicsDetailAdapter

class PicsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar_activity_pics_detail)
        val favouriteBtn: ImageView = findViewById(R.id.favorite_toolbar_activity_pics_detail)
        val moreBtn: ImageView = findViewById(R.id.more_toolbar_activity_pics_detail)
        val swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swipe_activity_pics_detail)
        val recyclerView: RecyclerView = findViewById(R.id.rv_activity_pics_detail)

//        setSupportActionBar(toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.adapter = PicsDetailAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        favouriteBtn.setOnClickListener {
            Toast.makeText(this, "you click favorite button!", Toast.LENGTH_SHORT).show()
        }
        moreBtn.setOnClickListener {
            Toast.makeText(this, "you click more button!", Toast.LENGTH_SHORT).show()
        }

        toolbar.setNavigationOnClickListener {
            finish()
        }
        swipeRefresh.setOnRefreshListener {
            if (swipeRefresh.isRefreshing) {
                swipeRefresh.isRefreshing = false
            }
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            android.R.id.home -> finish()
//        }
//        return true
//    }
}