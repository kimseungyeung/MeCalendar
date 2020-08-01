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

class MemoActivity : AppCompatActivity(), View.OnClickListener {
    var memolist:ArrayList<MemoData>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(R.layout.memo_activity)
        var i=intent
        val year=i.getStringExtra("year")
        val month=i.getStringExtra("month")
        val date=i.getStringExtra("date")
        tv_nowdate.text=year+"년 "+month+"월 "+date+"일 "
        init()
    }
    fun init(){
        memolist= arrayListOf()
        var adapter=ListAdapter(memolist)
        rl_memo.adapter=adapter
        rl_memo.layoutManager=LinearLayoutManager(this)
        btn_add.setOnClickListener(this)
        var work= OneTimeWorkRequest.Builder(DbselectWorker::class.java).build()
        var start=WorkManager.getInstance(this).enqueue(work)
    }
    fun setadapter(){
        rl_memo.adapter=ListAdapter(memolist)
        (rl_memo.adapter as ListAdapter).notifyDataSetChanged()
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_add->{
                val i  = Intent(this, MemoInsertActivity::class.java)
                startActivity(i)
            }

        }


    }

    inner class DbselectWorker(context:Context,workerp:WorkerParameters):Worker(context,workerp){

        override fun doWork(): Result {

            memolist= DbOpenHelper!!.select(database,20200801)
            setadapter()
            return Result.success()
        }
    }


}