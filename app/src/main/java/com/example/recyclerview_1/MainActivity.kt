package com.example.recyclerview_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VegetableAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvList1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val vegetableList = mutableListOf(
            Vegetable(R.drawable.Mushroom,"Mushrooms are high in non-plant protein and vitamin D"),
            Vegetable(R.drawable.Sugar_Beet,"Beet help reduce blood pressure"),
            Vegetable(R.drawable.Purple_Cabbage,"Purple cabbage has an attractive color and excellent antioxidants"),
            Vegetable(R.drawable.brussels_cabbage,"Brussels sprouts are beneficial for health")
        )
        adapter = VegetableAdapter(vegetableList)
        recyclerView.adapter = adapter

        //Add 1 new Vegetable on data list
        val newVegetable = Vegetable(R.drawable.ic_launcher_background,"cccccc")
        vegetableList.add(newVegetable)
        //Notification for adapter know that data changed
        adapter.notifyItemInserted(vegetableList.size - 1)

        //Delete 1 Vegetable at index in list
        vegetableList.removeAt(1)
        //Notification for adapter know that data changed
        adapter.notifyItemRemoved(1)

        //Update 1 Vegetable on data list
        val updateVegetable = Vegetable(R.drawable.ic_launcher_foreground,"col")
        vegetableList[1]= updateVegetable
        //Notification for adapter know that data changed
        adapter.notifyItemChanged(1)

    }
}