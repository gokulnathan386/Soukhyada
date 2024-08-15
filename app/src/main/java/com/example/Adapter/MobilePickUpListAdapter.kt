package com.soukhyada.soukhyadanew.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.databinding.CategoryRepairListBinding



internal class MobilePickUpListAdapter(
    private val context: Context

) : RecyclerView.Adapter<MobilePickUpListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: CategoryRepairListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryRepairListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        if(position == 9){

            holder.binding.viewTxt.visibility = View.GONE

        }


        holder.binding.categoryListBtn.setOnClickListener{

            if (holder.binding.mobileSubCategoryList.visibility == View.VISIBLE) {
                holder.binding.mobileSubCategoryList.visibility = View.GONE
            } else {
                holder.binding.mobileSubCategoryList.visibility = View.VISIBLE
            }

        }




        val mobileRepairSubcategoryListAdapter = MobileRepairSubcategoryListAdapter(context)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        holder.binding!!.mobileSubCategoryList.layoutManager = layoutManager
        holder.binding!!.mobileSubCategoryList.adapter = mobileRepairSubcategoryListAdapter


    }


    override fun getItemCount(): Int {
        return 10
    }
}