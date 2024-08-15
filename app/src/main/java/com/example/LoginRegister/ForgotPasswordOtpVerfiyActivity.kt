package com.soukhyada.soukhyadanew.LoginRegister

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityForgotPasswordOtpVerfiyBinding


class ForgotPasswordOtpVerfiyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordOtpVerfiyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityForgotPasswordOtpVerfiyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resendTxt.paintFlags = binding.resendTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.resendTxt.setOnClickListener {

        }

        binding.verifyOtpTxt.setOnClickListener{
           // val otp: String = binding.pinview.getText().toString()
            //Toast.makeText(this@ForgotPasswordOtpVerfiyActivity, otp, Toast.LENGTH_SHORT).show()
            //startActivity(Intent(this@ForgotPasswordOtpVerfiyActivity,ResetPasswordActivity::class.java))
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
    }
}