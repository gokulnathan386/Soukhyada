package com.soukhyada.soukhyadanew.Adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.databinding.MobileRepairServiceListBinding



internal class MobileRepairSubcategoryListAdapter(
    private val context: Context

) : RecyclerView.Adapter<MobileRepairSubcategoryListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: MobileRepairServiceListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MobileRepairServiceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.binding.amtMaxTxt.setText("₹7,000")
        holder.binding.amtMaxTxt.setPaintFlags(holder.binding.amtMaxTxt.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)


        if(position == 2){

            holder.binding.viewTxt.visibility = View.GONE

        }

        if(position == 1){
            holder.binding.addTxt.visibility = View.GONE
            holder.binding.removeTxt.visibility = View.VISIBLE
        }


    }


    override fun getItemCount(): Int {
        return 3
    }
}