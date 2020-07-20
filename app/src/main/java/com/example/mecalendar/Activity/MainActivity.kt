package com.example.mecalendar.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mecalendar.Adapter.CalendarAdapter
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_calendar.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var itemarray:ArrayList<String>?=null
    var month:Int=0
    var year:Int=0
    var nmonth:Int=0;
    var nyear=0;
    var ndate=0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        itemarray= arrayListOf()
        val d=Date()
        val calendar=Calendar.getInstance()
        month = (calendar.get(Calendar.MONTH))
        nmonth=month
        nyear=calendar.get(Calendar.YEAR)
        year=nyear
        ndate=calendar.get(Calendar.DATE)

        tv_month.text=year.toString()+"년 "+(month+1).toString()+"월"
        btn_nxt.setOnClickListener {
            if(month<11) {
                month++

            }else{
                month=0
                year++
            }
            (gv_calendar.adapter as CalendarAdapter).nyear=year
            (gv_calendar.adapter as CalendarAdapter).nmonth=month
            tv_month.text=year.toString()+"년 "+(month+1).toString()+"월"
        }
        btn_prv.setOnClickListener {
            if(month>0) {
                month--
            }else{
                month=11
                year--

            }
            (gv_calendar.adapter as CalendarAdapter).nyear=year
            (gv_calendar.adapter as CalendarAdapter).nmonth=month
            tv_month.text=year.toString()+"년 "+(month+1)
                .toString()+"월"
        }
       var cadapter= CalendarAdapter(this, gv_calendar)
        cadapter!!.nyear=nyear
        cadapter!!.nmonth=nmonth
        cadapter!!.ndate=ndate
        gv_calendar.adapter=cadapter
        gv_calendar.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,view.tv_date.text,
        Toast.LENGTH_SHORT).show()
            val i  = Intent(this, MemoActivity::class.java)
            i.putExtra("year",nyear.toString())
            i.putExtra("month",(nmonth+1).toString())
            i.putExtra("date",view.tv_date.text)
            startActivity(i)
        }


    }
}