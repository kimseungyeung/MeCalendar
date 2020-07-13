package com.example.mecalendar

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.item_calendar.view.*

class CalendarAdapter : BaseAdapter {
    var con:Context?=null



    constructor(context: Context) : super() {
        con=context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var inflater=con!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var view=inflater.inflate(R.layout.item_calendar,null)
        view.tv_date.text=position.toString()
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
      return 31
    }
    class ViewHolder {
        var tv_date:TextView?=null
    }

}