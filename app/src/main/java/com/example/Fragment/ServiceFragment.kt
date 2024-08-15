package com.soukhyada.soukhyadanew.Fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.soukhyada.soukhyadanew.Adapter.MobileServiceRepairGridViewListAdapter
import com.soukhyada.soukhyadanew.databinding.FragmentServiceBinding

class ServiceFragment : Fragment() {

    private var _binding: FragmentServiceBinding? = null
    private val  binding get() = _binding!!
    private lateinit var mobileServiceRepairGridViewListAdapter: MobileServiceRepairGridViewListAdapter

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentServiceBinding.inflate(inflater, container, false)


        val gridLayoutManager = GridLayoutManager(requireContext(), 4)
        _binding!!.serviceMobileRepair.layoutManager = gridLayoutManager
        mobileServiceRepairGridViewListAdapter = MobileServiceRepairGridViewListAdapter(requireContext())
        _binding!!.serviceMobileRepair.setHasFixedSize(true)
        _binding!!.serviceMobileRepair.adapter = mobileServiceRepairGridViewListAdapter


        return binding.root
    }

}

