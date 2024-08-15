package com.soukhyada.soukhyadanew.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.databinding.MobileServicesRepairBinding

import com.soukhyada.soukhyadanew.Repair.MobileModelActivity



internal class MobileServiceSeriesGridViewListAdapter(
    private val context: Context
) : RecyclerView.Adapter<MobileServiceSeriesGridViewListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: MobileServicesRepairBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MobileServicesRepairBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        if(position == 0){
            holder.binding.serviceNameTxt.text = "Battery"
        }else if (position == 1){
            holder.binding.serviceNameTxt.text = "Camera"
        }else if (position == 2){
            holder.binding.serviceNameTxt.text = "Screen"
        }else if (position == 3){
            holder.binding.serviceNameTxt.text = "Mic"
        }else if (position == 4){
            holder.binding.serviceNameTxt.text = "Charging\nJack"
        }

        holder.binding.seriesLayout.setOnClickListener{
            val intent = Intent(context, MobileModelActivity::class.java)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return 25
    }
}