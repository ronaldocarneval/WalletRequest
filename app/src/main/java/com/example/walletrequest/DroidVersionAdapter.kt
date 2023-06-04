package com.example.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DroidVersionAdapter (var listaDeCartoes: List<Card>): RecyclerView.Adapter<ItemViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDeCartoes.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {


        val cards:Card = listaDeCartoes[position]
        holder.configItem(cards)



    }
}