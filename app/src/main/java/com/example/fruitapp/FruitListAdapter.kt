package com.example.fruitapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class FruitListAdapter(var fruitList: ArrayList<Fruit>, var context: Context): RecyclerView.Adapter<FruitListAdapter.FruitListViewHolder>() {

    inner class FruitListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameTextView = itemView.findViewById<TextView>(R.id.tvFruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val fruitView = inflater.inflate(R.layout.item_fruit_row, parent, false)
        return FruitListViewHolder(fruitView)
    }

    override fun onBindViewHolder(holder: FruitListViewHolder, position: Int) {
        var fruit = fruitList.get(position)
        holder.nameTextView.text = fruit.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context,FruitDetails:: class.java)
            intent.putExtra("FruitDetails", fruit)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}