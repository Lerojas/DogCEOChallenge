package com.androidavanzado.dogceochallenge.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidavanzado.dogceochallenge.R
import com.androidavanzado.dogceochallenge.presentation.views.OnItemClickListener

class BreedNameAdapter : RecyclerView.Adapter<BreedNameAdapter.MyViewHolder>() {

    private var breedNames = ArrayList<String>()
    lateinit var onItemClickListener : OnItemClickListener

    fun setListData(data: ArrayList<String>, onItemClickListener : OnItemClickListener){
        this.breedNames = data
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list_row, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.breedNameTv.text = breedNames[position]
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClickListener(breedNames[position])
        }
    }

    override fun getItemCount(): Int {
        return breedNames.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val breedNameTv : TextView = view.findViewById(R.id.breedNameTv)
    }
}





