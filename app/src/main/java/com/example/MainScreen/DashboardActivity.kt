package com.soukhyada.soukhyadanew.MainScreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.soukhyada.R
import com.example.soukhyada.databinding.ActivityMainBinding
import com.soukhyada.soukhyadanew.Fragment.HomeFragment
import com.soukhyada.soukhyadanew.Fragment.ProjectFragment
import com.soukhyada.soukhyadanew.Fragment.ServiceFragment



class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TIME_INTERVAL = 2000
    private var mBackPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.bg_color_light_green)
        }
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)







        if (savedInstanceState == null) {
            showFragment(HomeFragment())
        }

    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed()
          /*  val backBtnIntent = Intent(Intent.ACTION_MAIN).apply {
                addCategory(Intent.CATEGORY_HOME)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(backBtnIntent)*/
        } else {
            Toast.makeText(baseContext, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        }

        mBackPressed = System.currentTimeMillis()
    }

}