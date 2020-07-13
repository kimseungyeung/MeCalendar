package com.example.mecalendar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.item_calendar.view.*

class CalendarAdapter : BaseAdapter {
    var con:Context?=null
    var itemheight:Int=0
    var gv_calendar:GridView?=null

    constructor(context: Context,gv:GridView) : super() {
        con=context
        gv_calendar=gv
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var inflater=con!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var view=inflater.inflate(R.layout.item_calendar,null)
        itemheight=gv_calendar!!.height/6

        var param:ViewGroup.LayoutParams?=null
        if(param==null){
            param=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        param.height=itemheight
        view.tv_date.text=position.toString()
        view.layoutParams=param
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
      return 42
    }
    class ViewHolder{
        var tv_date:TextView?=null
    }

}