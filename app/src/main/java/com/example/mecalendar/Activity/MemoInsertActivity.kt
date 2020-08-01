package com.example.mecalendar.Activity

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.insert_activity.*
import kotlinx.android.synthetic.main.item_memo.*

class MemoInsertActivity :AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insert_activity)
        init()
    }
    fun init(){
        btn_insert.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v!!.id){
            R.id.btn_insert->{
            var work= OneTimeWorkRequest.Builder(InsertWorker::class.java).build()
                var start=WorkManager.getInstance(this).enqueue(work)
            }
        }
    }
    fun getdrawable():Drawable{
        return iv_picture.drawable
    }
   inner class InsertWorker(context: Context,work:WorkerParameters):Worker(context,work){
        override fun doWork(): Result {
            var d=  getdrawable()
            var bd:Bitmap=(d as BitmapDrawable).bitmap
            DbOpenHelper!!.insert(database,0,20200726,1909,bd,tv_memo.text.toString())
            finish()
            return Result.success()
        }

    }
}