package com.horshun.saveup.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.horshun.saveup.R
import com.horshun.saveup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindViews()
    }

    private fun bindViews() {
        with(binding) {
            btnHome.setOnClick { vpMain.findNavController().navigate(R.id.homeFragment) }
            btnArticle.setOnClick { vpMain.findNavController().navigate(R.id.articleFragment) }
            btnUser.setOnClick { vpMain.findNavController().navigate(R.id.profileFragment) }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun View.setOnClick(clickEvent: () -> Unit) {
        this.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                clickEvent.invoke()
            }
            false
        }
    }
}