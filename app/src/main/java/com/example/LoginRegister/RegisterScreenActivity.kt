package com.soukhyada.soukhyadanew.LoginRegister

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityRegisterscreenBinding
import com.soukhyada.soukhyadanew.MainScreen.DashboardActivity


class RegisterScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterscreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityRegisterscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signTxt.paintFlags = binding.signTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.signUptxtUser.setOnClickListener{
       //     startActivity(Intent(this@RegisterScreenActivity,LoginScreenActivity::class.java))
        }

        binding.signUpPageTxt.setOnClickListener {
        //    startActivity(Intent(this@RegisterScreenActivity, DashboardActivity::class.java))
        }

    }
}