package com.example.mecalendar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mecalendar.Data.MemoData
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import kotlinx.android.synthetic.main.item_calendar.view.tv_memo
import kotlinx.android.synthetic.main.item_memo.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder> {
    var memolist:ArrayList<MemoData>?=null

    constructor(memolist: ArrayList<MemoData>?) : super() {
        this.memolist = memolist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_memo,parent,false)
        val viewHolder=
            ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return memolist!!.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data=memolist!!.get(position)
        holder.iv_memo.setImageBitmap(data.image)
        holder.tv_memo.text=(data.time+"  "+data.memo)
    }
    class ViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView){
            val tv_memo=itemView.tv_memo
            val iv_memo=itemView.iv_memo
    }
}