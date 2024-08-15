package com.soukhyada.soukhyadanew.Repair

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.soukhyada.soukhyadanew.Adapter.MobileModelRepairListAdapter
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityMobileModelBinding

class MobileModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMobileModelBinding
    private lateinit var mobileModelRepairListAdapter: MobileModelRepairListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }

        binding = ActivityMobileModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        val gridLayoutManager = GridLayoutManager(this, 4)
        binding!!.mobileModelRepair.layoutManager = gridLayoutManager
        mobileModelRepairListAdapter = MobileModelRepairListAdapter(this)
        binding!!.mobileModelRepair.setHasFixedSize(true)
        binding!!.mobileModelRepair.adapter = mobileModelRepairListAdapter



    }
}