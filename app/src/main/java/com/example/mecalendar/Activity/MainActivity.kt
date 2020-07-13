package com.example.mecalendar.Activity

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    fun init(){
        itemarray= arrayListOf()
        val d=Date()
        val calendar=Calendar.getInstance()
        month = (calendar.get(Calendar.MONTH)+1)
        tv_month.text=month.toString()
        btn_nxt.setOnClickListener {
            if(month<12) {
                month++
                tv_month.text = month.toString()
            }else{
                month=1
                tv_month.text = month.toString()
            }
        }
        btn_prv.setOnClickListener {
            if(month>1) {
                month--
                tv_month.text = month.toString()
            }else{
                month=12
                tv_month.text = month.toString()
            }
        }
        gv_calendar.adapter=
            CalendarAdapter(this, gv_calendar)
        gv_calendar.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,view.tv_date.text,
        Toast.LENGTH_SHORT).show()  }

    }
}