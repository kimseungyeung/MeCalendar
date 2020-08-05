package com.example.mecalendar.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import com.example.mecalendar.Adapter.ListAdapter
import com.example.mecalendar.Data.MemoData
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.memo_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MemoActivity : AppCompatActivity(), View.OnClickListener {
    var memolist:ArrayList<MemoData>?=null
    var tdate:Int?=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(R.layout.memo_activity)
        var i=intent
        val year=i.getStringExtra("year")
        val month=i.getStringExtra("month")
        val date=i.getStringExtra("date")

        tdate=(year+month+date).toInt()
        tv_nowdate.text=year+"년 "+month+"월 "+date+"일 "
        init()
    }
    fun init(){
        memolist= arrayListOf()
        var adapter=ListAdapter(memolist)
        rl_memo.adapter=adapter
        rl_memo.layoutManager=LinearLayoutManager(this)
        btn_add.setOnClickListener(this)
        CoroutineScope(Dispatchers.Main).launch {
            memolist= DbOpenHelper!!.select(database,tdate!!)
            setadapter()
        }
    }
    fun setadapter(){
        rl_memo.adapter=ListAdapter(memolist)
        (rl_memo.adapter as ListAdapter).notifyDataSetChanged()
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_add->{
                val i  = Intent(this, MemoInsertActivity::class.java)
                startActivityForResult(i,1)
            }

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        CoroutineScope(Dispatchers.Main).launch {
            memolist= DbOpenHelper!!.select(database,tdate!!)
            setadapter()
        }
    }



}