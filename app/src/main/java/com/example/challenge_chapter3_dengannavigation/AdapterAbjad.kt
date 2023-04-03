package com.example.challenge_chapter3_dengannavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterAbjad(private val abjadList:ArrayList<DataAbjad>, private val onItemClick:(DataAbjad)->Unit):
    RecyclerView.Adapter<AdapterAbjad.AbjadViewHolder>(){

    inner class AbjadViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val abjadTextView: TextView = itemView.findViewById(R.id.tv_item)
        fun bind(abjad:DataAbjad){
            abjadTextView.text = abjad.toString()
            itemView.setOnClickListener { onItemClick(abjad) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AbjadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return AbjadViewHolder(view)
    }

    override fun onBindViewHolder(holder: AbjadViewHolder, position: Int) {
        holder.bind(abjadList[position])
    }

    override fun getItemCount(): Int {
        return abjadList.size
    }


}