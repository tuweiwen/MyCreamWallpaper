package com.example.mycreamwallpaper.activity

import android.content.Context
import android.os.Bundle
import android.transition.Fade
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mycreamwallpaper.R


class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fade = Fade()
        window.enterTransition = fade
        window.exitTransition = fade

        setContentView(R.layout.activity_search)

        val toolbar: Toolbar = findViewById(R.id.toolbar_activity_search)
        val editText: EditText = findViewById(R.id.search_input_activity_search)

        toolbar.setNavigationOnClickListener {
            finishAfterTransition()
        }

        editText.requestFocus()
        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
}