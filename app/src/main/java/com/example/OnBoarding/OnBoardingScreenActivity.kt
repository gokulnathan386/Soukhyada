package com.soukhyada.soukhyadanew.OnBoarding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityOnBoardingScreenBinding
import com.soukhyada.soukhyadanew.Adapter.OnBoardingItem
import com.soukhyada.soukhyadanew.Adapter.OnboardingAdapter
import com.soukhyada.soukhyadanew.LoginRegister.LoginScreenActivity


class OnBoardingScreenActivity : AppCompatActivity() {

      private lateinit var binding: ActivityOnBoardingScreenBinding
     private var onboardingAdapter: OnboardingAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setOnboardingItem()

        binding.onboardingViewPager.adapter = onboardingAdapter

        setOnboadingIndicator()
        setCurrentOnboardingIndicators(0)

        binding.onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentOnboardingIndicators(position)
            }
        })

        binding.buttonOnBoardingAction.setOnClickListener {
            if (binding.onboardingViewPager.currentItem + 1 < onboardingAdapter!!.itemCount) {
                binding.onboardingViewPager.currentItem += 1
            } else {
                startActivity(Intent(applicationContext, LoginScreenActivity::class.java))
                finish()
            }
        }

    }

    private fun setOnboadingIndicator() {
        val indicators = arrayOfNulls<ImageView>(
            onboardingAdapter!!.itemCount
        )
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.onboarding_indicator_inactive
                )
            )
            indicators[i]!!.layoutParams = layoutParams
            binding.layoutOnboardingIndicators.addView(indicators[i])
        }
    }


    private fun setOnboardingItem() {
        val onBoardingItems = mutableListOf<OnBoardingItem>()

        val itemFastFood = OnBoardingItem().apply {
            title = "Reliable solutions for all \nyour phone repair needs"
        //    description = "Our delivery partner is on the way to your home!"
            image = R.drawable.repairman_icon
        }

        val itemPayOnline = OnBoardingItem().apply {
            title = "We fix it right,\nthe first time"
        //    description = "Electric bill payment is a feature of online, mobile and net banking!"
            image = R.drawable.repair_man_1
        }

        val itemEatTogether = OnBoardingItem().apply {
            title = "Safe & Secure Pick \nus & Delivery"
          //  description = "Enjoy your meal and have a great day. Don't forget to rate us!"
            image = R.drawable.on_the_way
        }

        onBoardingItems.add(itemFastFood)
        onBoardingItems.add(itemPayOnline)
        onBoardingItems.add(itemEatTogether)

        onboardingAdapter = OnboardingAdapter(onBoardingItems)
    }

    @SuppressLint("SetTextI18n")
    private fun setCurrentOnboardingIndicators(index: Int) {
        val childCount = binding.layoutOnboardingIndicators.childCount
        for (i in 0 until childCount) {
            val imageView = binding.layoutOnboardingIndicators.getChildAt(i) as ImageView
            val drawableRes = if (i == index) {
                R.drawable.onboarding_indicator_active
            } else {
                R.drawable.onboarding_indicator_inactive
            }
            imageView.setImageDrawable(ContextCompat.getDrawable(this, drawableRes))
        }

         binding.buttonOnBoardingAction.text = if (index == onboardingAdapter!!.itemCount - 1) {
            "Start"
        } else {
            "Next"
        }
    }

}