package com.soukhyada.soukhyadanew.Repair

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityMobileSeriesBinding
import com.soukhyada.soukhyadanew.Adapter.MobileServiceSeriesGridViewListAdapter


class MobileSeriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMobileSeriesBinding
    private lateinit var mobileServiceSeriesGridViewListAdapter: MobileServiceSeriesGridViewListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityMobileSeriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }


        val gridLayoutManager = GridLayoutManager(this, 4)
        binding!!.mobileSeriesRepair.layoutManager = gridLayoutManager
        mobileServiceSeriesGridViewListAdapter = MobileServiceSeriesGridViewListAdapter(this)
        binding!!.mobileSeriesRepair.setHasFixedSize(true)
        binding!!.mobileSeriesRepair.adapter = mobileServiceSeriesGridViewListAdapter


    }
}