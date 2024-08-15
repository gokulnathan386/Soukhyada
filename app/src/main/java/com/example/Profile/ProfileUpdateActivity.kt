package com.soukhyada.soukhyadanew.Profile

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soukhyada.soukhyadanew.R
import com.soukhyada.soukhyadanew.databinding.ActivityProfileUpdateBinding

class ProfileUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityProfileUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}