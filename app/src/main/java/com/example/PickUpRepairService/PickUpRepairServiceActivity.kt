package com.soukhyada.soukhyadanew.PickUpRepairService

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityPickUpRepairServiceBinding

import com.soukhyada.soukhyadanew.Adapter.MobilePickUpListAdapter



class PickUpRepairServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPickUpRepairServiceBinding

    private lateinit var mobilePickUpListAdapter: MobilePickUpListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityPickUpRepairServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener {
            finish()
        }

        mobilePickUpListAdapter = MobilePickUpListAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding!!.mobileRepairList.layoutManager = layoutManager
        binding!!.mobileRepairList.adapter = mobilePickUpListAdapter


    }
}