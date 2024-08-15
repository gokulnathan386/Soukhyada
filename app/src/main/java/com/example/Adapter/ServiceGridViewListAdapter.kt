package com.soukhyada.soukhyadanew.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.databinding.ServicesListRepairBinding



internal class ServiceGridViewListAdapter(
    private val context: Context
) : RecyclerView.Adapter<ServiceGridViewListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: ServicesListRepairBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ServicesListRepairBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     //    val imageView = holder.binding.mobileImage
         val mobileNameTxt = holder.binding.serviceNameTxt

        if(position == 0){
            mobileNameTxt.text = "Battery"
        }else if (position == 1){
            mobileNameTxt.text = "Camera"
        }else if (position == 2){
            mobileNameTxt.text = "Screen"
        }else if (position == 3){
            mobileNameTxt.text = "Mic"
        }else if (position == 4){
            mobileNameTxt.text = "Charging\nJack"
        }

    }

    override fun getItemCount(): Int {
        return 5
    }
}
