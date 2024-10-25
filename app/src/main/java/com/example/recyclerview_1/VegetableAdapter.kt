package com.example.recyclerview_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class VegetableAdapter(private val list:List<Vegetable>):RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder>() {


    //Manage 1 ViewHolder -- 1 item in RecycleView
    class VegetableViewHolder(view: View):ViewHolder(view){
        val imgVegetable = view.findViewById<ImageView>(R.id.imgVegetable)
        val tvMoTa = view.findViewById<TextView>(R.id.tvMoTa)

        fun onBind(vegetable: Vegetable){
            tvMoTa.text = vegetable.title
            imgVegetable.id = vegetable.imageResource
        }
    }
    //Create 1 ViewHolder
    //One ViewHolder be called one time
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.vegetable_item, parent, false)
        return VegetableViewHolder(view)
    }

    // Return all position item in list
    override fun getItemCount(): Int {
        return list.size
    }


    // Encapsulation ViewHolder
    override fun onBindViewHolder(holder: VegetableViewHolder, position: Int) {
        //position( index cua list)
        //data in position = list[position]
        holder.onBind(list[position])
    }
}