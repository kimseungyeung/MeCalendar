package com.example.mecalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
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
            month++
            tv_month.text=month.toString()
        }
        btn_prv.setOnClickListener {
            month--
            tv_month.text=month.toString()
        }
        listcalendar.adapter=CalendarAdapter(this)
    }
}