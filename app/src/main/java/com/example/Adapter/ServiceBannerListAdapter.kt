package com.soukhyada.soukhyadanew.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.databinding.ServiceCategoryListBinding



internal class ServiceBannerListAdapter(
    private val context: Context

) : RecyclerView.Adapter<ServiceBannerListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: ServiceCategoryListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ServiceCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

  //      val imageView = holder.binding.mobileImage
  //      val mobileNameTxt = holder.binding.mobileNameTxt



    }


    override fun getItemCount(): Int {
        return 3
    }
}