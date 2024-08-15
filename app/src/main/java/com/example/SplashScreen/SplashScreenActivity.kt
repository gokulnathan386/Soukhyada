package com.soukhyada.soukhyadanew.SplashScreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import com.soukhyada.soukhyadanew.OnBoarding.OnBoardingScreenActivity
import com.soukhyada.soukhyadanew.R
import com.soukhyada.soukhyadanew.databinding.ActivityLoginScreenBinding
import com.soukhyada.soukhyadanew.databinding.ActivitySplashScreenBinding

import pl.droidsonroids.gif.GifDrawable
import java.io.IOException

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.splash_bar_status)
        }

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val gifDrawable = GifDrawable(resources, R.drawable.splash_gif_icon)
            gifDrawable.loopCount = 0
            binding.gifImageView.setImageDrawable(gifDrawable)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        Handler().postDelayed({
        //    val intent = Intent(this, MainActivity::class.java)
          /*  val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
            finish()*/

            val intent = Intent(this, ActivityLoginScreenBinding::class.java)
            startActivity(intent)
            finish()


        }, 2000)
    }
}
