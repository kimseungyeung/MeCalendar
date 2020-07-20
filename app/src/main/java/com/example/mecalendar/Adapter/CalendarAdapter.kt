package com.example.mecalendar.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.item_calendar.view.*
import java.util.*

class CalendarAdapter : BaseAdapter {
    var con:Context?=null
    var itemheight:Int=0
    var gv_calendar:GridView?=null
    var nyear:Int = 0
        set(year:Int)
            {calendar!!.set(Calendar.YEAR,year)
            field=year
            }
    var nmonth:Int=0
        set(month:Int)
        {
            calendar!!.set(Calendar.MONTH,month)
            field=month
            ndate=1
            startdate = calendar!!.get(Calendar.DAY_OF_WEEK)
            enddate= calendar!!.getActualMaximum(Calendar.DATE)
        }
    var ndate:Int=0
    set(value:Int) {
        field=value
        calendar!!.set(Calendar.DATE,value)
        notifyDataSetChanged()
        Log.d("start", nyear.toString()+"년 "+nmonth+"월 "+ndate+"일 ")}
    var startdate:Int=0
    set(value:Int) {Log.d("startdate",value.toString())
                    field=value}
    var enddate:Int=0
        set(value:Int) {Log.d("enddate",value.toString())
            field=value}
    var calendar:Calendar?=null
    constructor(context: Context,gv:GridView) : super() {
        con=context
        gv_calendar=gv
        calendar= Calendar.getInstance()
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



        if((position+1)>=startdate&&(position+1-startdate)<(enddate)) {

            view.tv_date.text = ((position+2)-startdate).toString()
        }else{
            view.tv_date.text=""
            view.tv_memo.text=""
        }
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


}