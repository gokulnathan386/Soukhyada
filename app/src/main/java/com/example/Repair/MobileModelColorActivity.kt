package com.soukhyada.soukhyadanew.Repair

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityMobileModelColorBinding
import com.soukhyada.soukhyadanew.Adapter.MobileColorGridViewListAdapter


class MobileModelColorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMobileModelColorBinding

    private lateinit var mobileColorGridViewListAdapter: MobileColorGridViewListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMobileModelColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val gridLayoutManager = GridLayoutManager(this, 4)
        binding!!.mobileColorRepair.layoutManager = gridLayoutManager
        mobileColorGridViewListAdapter = MobileColorGridViewListAdapter(this)
        binding!!.mobileColorRepair.setHasFixedSize(true)
        binding!!.mobileColorRepair.adapter = mobileColorGridViewListAdapter

    }
}