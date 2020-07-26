package com.example.mecalendar.Activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        for(i in 1..10){
            var time=1311+i
            //var dd=resources.getDrawable(R.drawable.ic_launcher_foreground)
            var ddd=BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_foreground)
            var d=MemoData(time.toString(),"오후일과", ddd)
            memolist!!.add(d)
        }
        var adapter=ListAdapter(memolist)
        rl_memo.adapter=adapter
        rl_memo.layoutManager=LinearLayoutManager(this)
        btn_add.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_add->{
                val i  = Intent(this, MemoInsertActivity::class.java)
                startActivityForResult(i)
            }

        }
    }

    private fun startActivityForResult(i: Intent) {
        (rl_memo.adapter as ListAdapter).memolist= DbOpenHelper!!.select(database,20200726)
        rl_memo.adapter!!.notifyDataSetChanged()
    }

}