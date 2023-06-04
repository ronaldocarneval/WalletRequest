package com.example.walletrequest

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    private var tvName: TextView
    private var tvNumber: TextView
    private var tvVencimento: TextView
    private var clContainer: ConstraintLayout

    init {
        tvName = itemView.findViewById<TextView>(R.id.tvCardNome2)
        tvNumber = itemView.findViewById<TextView>(R.id.tvCardNumber2)
        tvVencimento = itemView.findViewById<TextView>(R.id.tvCardValidade2)
        clContainer = itemView.findViewById(R.id.tvItemVersionName)
    }
    fun configItem(cards: Card) {
        tvNumber.text = cards.number
        tvVencimento.text = cards.expirationDate
        tvName.text = cards.name

    }


}