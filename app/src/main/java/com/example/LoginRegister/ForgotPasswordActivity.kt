package com.soukhyada.soukhyadanew.LoginRegister

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityForgotPasswordBinding


class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener{
            finish()
        }

        binding.recoverPasswordTxt.setOnClickListener {
            startActivity(Intent(this@ForgotPasswordActivity,ForgotPasswordOtpVerfiyActivity::class.java))
        }


    }
}