package com.soukhyada.soukhyadanew.Fragment

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.soukhyada.soukhyadanew.Adapter.MobileCategoryListAdapter
import com.soukhyada.soukhyadanew.Adapter.ServiceBannerListAdapter
import com.soukhyada.soukhyadanew.Adapter.ServiceGridViewListAdapter
import com.soukhyada.soukhyadanew.Adapter.ViewPagerAdapter
import com.soukhyada.soukhyadanew.Profile.ProfileScreenActivity
import com.soukhyada.soukhyadanew.databinding.FragmentHomeBinding
import java.io.IOException
import java.util.Locale

class HomeFragment : Fragment(), ViewPager.OnPageChangeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dots: Array<ImageView?>
    private lateinit var mAdapter: ViewPagerAdapter

    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var currentPage = 0
    private var dotsCount = 0

    private lateinit var mobileCategoryListAdapter: MobileCategoryListAdapter
    private lateinit var serviceBannerListAdapter: ServiceBannerListAdapter
    private lateinit var serviceGridViewListAdapter: ServiceGridViewListAdapter

 /*   private val mImageResources = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image1
    )*/

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var settingsClient: SettingsClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationSettingsRequest: LocationSettingsRequest

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding!!.profileImgCardView.setOnClickListener {
      //      startActivity(Intent(requireContext(), ProfileScreenActivity::class.java))
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())
        settingsClient = LocationServices.getSettingsClient(requireContext())



        setReference()
        mobileCategoryList()
        requestLocationPermission()
        return binding.root
    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            checkLocationSettings()
        }
    }

    private fun mobileCategoryList() {


        mobileCategoryListAdapter = MobileCategoryListAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        _binding!!.mobileCategoryList.layoutManager = layoutManager
        _binding!!.mobileCategoryList.adapter = mobileCategoryListAdapter


        serviceBannerListAdapter = ServiceBannerListAdapter(requireContext())
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        _binding!!.serviceBanner.layoutManager = linearLayoutManager
        _binding!!.serviceBanner.adapter = serviceBannerListAdapter


        val gridLayoutManager = GridLayoutManager(requireContext(), 4)
        _binding!!.serviceList.layoutManager = gridLayoutManager
        serviceGridViewListAdapter = ServiceGridViewListAdapter(requireContext())
        _binding!!.serviceList.setHasFixedSize(true)
        _binding!!.serviceList.adapter = serviceGridViewListAdapter





    }

    private fun setReference() {
    //    mAdapter = ViewPagerAdapter(requireContext(), mImageResources)
        _binding!!.pagerIntroduction.adapter = mAdapter
        _binding!!.pagerIntroduction.currentItem = 0
        _binding!!.pagerIntroduction.addOnPageChangeListener(this)
        setUiPageViewController()
        startAutoSlider()
    }

    private fun startAutoSlider() {
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (currentPage == dotsCount) {
                    currentPage = 0
                }
                _binding?.pagerIntroduction?.setCurrentItem(currentPage++, true)
                handler?.postDelayed(this, 3000)
            }
        }
        handler?.postDelayed(runnable!!, 3000)
    }

    private fun stopAutoSlider() {
        handler?.removeCallbacks(runnable!!)
    }

    private fun setUiPageViewController() {
        dotsCount = mAdapter.count
        dots = arrayOfNulls(dotsCount)

     /*   for (i in 0 until dotsCount) {
            dots[i] = ImageView(requireContext())
       //     dots[i]!!.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 0, 4, 0)

            _binding!!.viewPagerCountDots.addView(dots[i], params)
        }*/

       // dots[0]!!.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
/*        for (i in 0 until dotsCount) {
            dots[i]!!.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))
        }
        dots[position]!!.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))*/
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onDestroyView() {
        super.onDestroyView()
        stopAutoSlider()
        _binding = null
    }

/*    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkLocationSettings()
                    Toast.makeText(requireContext(), "Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }*/

    private fun checkLocationSettings() {

      /*  locationRequest = LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }*/

        val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)
        locationSettingsRequest = builder.build()

        settingsClient.checkLocationSettings(locationSettingsRequest)
            .addOnSuccessListener {
                enableLocationFeatures()

            }
            .addOnFailureListener { e ->
                if (e is ResolvableApiException) {
                    try {
                        e.startResolutionForResult(requireActivity(), 2)
                    } catch (sendEx: IntentSender.SendIntentException) {
                        Log.e("HomeFragment-Error", "SendIntentException: " + sendEx.message)
                    }
                } else {
                        Log.e("HomeFragment-Error", "Location settings are not satisfied: " + e.localizedMessage)
                }

            }
    }

    private fun enableLocationFeatures() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

//            locationRequest = LocationRequest.create().apply {
//                interval = 5000
//                fastestInterval = 2500
//                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//            }

            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    p0 ?: return
                    for (location in p0.locations) {
                        if (location != null) {
                            // Check if fragment is added and context is available
                            if (isAdded) {
                                try {
                                    val geocoder = Geocoder(requireContext(), Locale.getDefault())
                                    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                                 /*   if (addresses != null && addresses.isNotEmpty()) {
                                        val address = addresses[0]
                                        _binding?.currentLocationTxt?.text = "${address.locality}, ${address.adminArea}"
                                    }*/
                                } catch (e: IOException) {
                                    e.printStackTrace()
                                    Log.e("HomeFragment-Error", "Geocoder exception: ${e.message}")
                                }

                                // Remove location updates if you only need the first location
                                fusedLocationClient.removeLocationUpdates(this)
                            }
                        }
                    }
                }

                override fun onLocationAvailability(p0: LocationAvailability) {
                    if (p0 != null && !p0.isLocationAvailable) {
                        Log.e("HomeFragment-Error", "Location is not available")
                    }
                }
            }

            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper())
        }
    }



}


/*
package com.koka.johnmobiles.Fragment
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.koka.johnmobiles.Adapter.ViewPagerAdapter
import com.koka.johnmobiles.Profile.ProfileScreenActivity
import com.koka.johnmobiles.R
import com.koka.johnmobiles.databinding.FragmentHomeBinding
import android.os.Handler
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient
import com.google.android.gms.tasks.OnCompleteListener
import com.koka.johnmobiles.Adapter.MobileCategoryListAdapter

class HomeFragment : Fragment(), ViewPager.OnPageChangeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dots: Array<ImageView?>
    private lateinit var mAdapter: ViewPagerAdapter

    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var currentPage = 0
    private var dotsCount = 0

    private lateinit var mobileCategoryListAdapter: MobileCategoryListAdapter

    private val mImageResources = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image1
    )

    private lateinit var fusedLocationClient: FusedLocationProviderClient



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding!!.profileImgCardView.setOnClickListener {
            startActivity(Intent(requireContext(), ProfileScreenActivity::class.java))
        }



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())


        setReference()
        mobileCategoryList()
        requestLocationPermission()
        return binding.root
    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        } else {
            enableLocationFeatures()
        }
    }

    private fun mobileCategoryList() {

        mobileCategoryListAdapter = MobileCategoryListAdapter(requireContext())
        val layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
         _binding!!.mobileCategoryList.layoutManager = layoutManager
         _binding!!.mobileCategoryList.adapter = mobileCategoryListAdapter

    }

    private fun setReference() {
        mAdapter = ViewPagerAdapter(requireContext(), mImageResources)
        _binding!!.pagerIntroduction.adapter = mAdapter
        _binding!!.pagerIntroduction.currentItem = 0
        _binding!!.pagerIntroduction.addOnPageChangeListener(this)
        setUiPageViewController()
        startAutoSlider()
    }

    private fun startAutoSlider() {
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                if (currentPage == dotsCount) {
                    currentPage = 0
                }
                _binding?.pagerIntroduction?.setCurrentItem(currentPage++, true)
                handler?.postDelayed(this, 3000)
            }
        }
        handler?.postDelayed(runnable!!, 3000)
    }

    private fun stopAutoSlider() {
        handler?.removeCallbacks(runnable!!)
    }

    private fun setUiPageViewController() {
        dotsCount = mAdapter.count
        dots = arrayOfNulls(dotsCount)

        for (i in 0 until dotsCount) {
            dots[i] = ImageView(requireContext())
            dots[i]!!.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 0, 4, 0)

            _binding!!.viewPagerCountDots.addView(dots[i], params)
        }

        dots[0]!!.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        for (i in 0 until dotsCount) {
            dots[i]!!.setImageDrawable(resources.getDrawable(R.drawable.nonselecteditem_dot))
        }
        dots[position]!!.setImageDrawable(resources.getDrawable(R.drawable.selecteditem_dot))
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onDestroyView() {
        super.onDestroyView()
        stopAutoSlider()
        _binding = null
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableLocationFeatures()
                    Toast.makeText(requireContext(), "Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun enableLocationFeatures() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                 == PackageManager.PERMISSION_GRANTED) {

            fusedLocationClient.lastLocation
                .addOnCompleteListener(requireActivity(), OnCompleteListener<Location> { task ->
                    if (task.isSuccessful && task.result != null) {
                        val location: Location? = task.result
                        if (location != null) {
                            Toast.makeText(requireContext(), "Location: ${location.latitude}, ${location.longitude}", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "Failed to get location", Toast.LENGTH_SHORT).show()
                    }
                })

        }
    }
}

*/
