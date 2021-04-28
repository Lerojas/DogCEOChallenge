package com.androidavanzado.dogceochallenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.androidavanzado.dogceochallenge.R
import com.bumptech.glide.Glide

class BreedImageAdapter :  RecyclerView.Adapter<BreedImageAdapter.MyViewHolder>() {

    var breedImages = ArrayList<String>()

    fun setListData(data: ArrayList<String>){
        this.breedImages = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list_image, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageUrl = breedImages[position]

        Glide.with(holder.breedImageIv)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.breedImageIv)
    }

    override fun getItemCount(): Int {
        return breedImages.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val breedImageIv : ImageView = view.findViewById(R.id.breedImageIv)
    }
}