package com.soukhyada.soukhyadanew.LoginRegister

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityLoginScreenBinding

import com.soukhyada.soukhyadanew.MainScreen.DashboardActivity

class LoginScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.forgetTxt.paintFlags =  binding.forgetTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.signTxt.paintFlags = binding.signTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.signUpTxtUser.setOnClickListener{
       //     startActivity(Intent(this@LoginScreenActivity,PhoneNumberOtpActivity::class.java))
        }

        binding.forgetTxt.setOnClickListener {
       //     startActivity(Intent(this@LoginScreenActivity,ForgotPasswordActivity::class.java))
        }

        binding.signTxtBtn.setOnClickListener {
         //   startActivity(Intent(this@LoginScreenActivity, DashboardActivity::class.java))
        }

    }
}