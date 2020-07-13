package com.example.mecalendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_calendar.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_calendar,parent,false)
        val viewHolder=ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 31;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_date.text=((position+1).toString()+"")
    }
    class ViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView){
            val tv_date=itemView.tv_date
            val tv_memo=itemView.tv_memo
    }
}