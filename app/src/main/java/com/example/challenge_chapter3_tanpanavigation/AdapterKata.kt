package com.example.challenge_chapter3_tanpanavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterKata(private val kataList:ArrayList<DataKata>, private val onKataClickListener: FragmentKata):
    RecyclerView.Adapter<AdapterKata.KataViewHolder>(){

    interface OnKataClickListener{
        fun onKataClicked(kata: DataKata)
    }

    inner class KataViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val kataTextView : TextView = itemView.findViewById(R.id.tv_item)
        fun bind(kata:DataKata){
            kataTextView.text = kata.kata

            itemView.setOnClickListener {
                onKataClickListener.onKataClicked(kata)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return KataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KataViewHolder, position: Int) {
        holder.bind(kataList[position])
    }

    override fun getItemCount() = kataList.size

}