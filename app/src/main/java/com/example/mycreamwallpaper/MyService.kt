package com.example.mycreamwallpaper

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService(): Service() {
    override fun onBind(p0: Intent): IBinder {
        TODO("Not yet implemented")
    }

    class MyBinder(): Binder() {

    }
}