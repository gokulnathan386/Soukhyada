package com.soukhyada.soukhyadanew.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.soukhyada.R
import com.example.soukhyada.databinding.MobileCategoryListBinding



internal class MobileCategoryListAdapter(
    private val context: Context

) : RecyclerView.Adapter<MobileCategoryListAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding: MobileCategoryListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MobileCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val imageView = holder.binding.mobileImage
        val mobileNameTxt = holder.binding.mobileNameTxt

        if (position == 0) {

            imageView.setBackgroundResource(R.drawable.oppo_icon)
            mobileNameTxt.text = "Oppo"

        }else if(position == 1){

            imageView.setBackgroundResource(R.drawable.vivo_icon)
            mobileNameTxt.text = "Vivo"

        }else if(position == 2){

            imageView.setBackgroundResource(R.drawable.nokia_icon)
            mobileNameTxt.text = "Nokia"

        }else if(position == 3){

            imageView.setBackgroundResource(R.drawable.motorola_icon)
             mobileNameTxt.text = "Motorola"

        }else if(position == 4){

            imageView.setBackgroundResource(R.drawable.iqoo_icon)
            mobileNameTxt.text = "Iqoo"

        }else if(position == 5){

            imageView.setBackgroundResource(R.drawable.mi_icon)
            mobileNameTxt.text = "Mi"

        }else if(position == 6){

            imageView.setBackgroundResource(R.drawable.sumgam_icon)
            mobileNameTxt.text = "Samsung"

        }else if(position == 7){

            imageView.setBackgroundResource(R.drawable.infnix_icon)
            mobileNameTxt.text = "Infnix"

        }else if(position == 8){

            imageView.setBackgroundResource(R.drawable.poco_icon)
            mobileNameTxt.text = "Poco"

        } else if(position == 9){

            imageView.setBackgroundResource(R.drawable.lg_icon)
            mobileNameTxt.text = "LG"

        } else if(position == 10){

            imageView.setBackgroundResource(R.drawable.apple_icon)
            mobileNameTxt.text = "Apple"

        }


    }


    override fun getItemCount(): Int {
        return 11
    }
}