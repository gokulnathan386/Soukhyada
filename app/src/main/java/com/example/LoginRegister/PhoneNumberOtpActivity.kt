package com.soukhyada.soukhyadanew.LoginRegister

import android.content.Intent
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityPhoneNumberOtpBinding


class PhoneNumberOtpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneNumberOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityPhoneNumberOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resendTxt.paintFlags = binding.resendTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.signTxt.paintFlags = binding.signTxt.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.otpVerfiy.setOnClickListener {
            startActivity(Intent(this@PhoneNumberOtpActivity,RegisterScreenActivity::class.java))
        }

        binding.signUptxtUser.setOnClickListener{
            startActivity(Intent(this@PhoneNumberOtpActivity,LoginScreenActivity::class.java))
        }

        binding.getOtpTxt.setOnClickListener {
          binding.getOtpMobilenoTxt.visibility = View.VISIBLE
        }


    }
}