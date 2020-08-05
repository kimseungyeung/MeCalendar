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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
//            var work= OneTimeWorkRequest.Builder(InsertWorker::class.java).build()
//                var start=WorkManager.getInstance(this).enqueue(work)
                CoroutineScope(Dispatchers.Main).launch {
                    var d=  iv_picture.drawable
                    var bd:Bitmap?=null
                         bd = (d as BitmapDrawable).bitmap
                    DbOpenHelper!!.insert(database,0,20200805,1909,bd!!,edt_memo.text.toString())
                    finish()
                }
            }
        }
    }
    public fun getdrawable():Drawable{
        return iv_picture.drawable
    }
    inner class InsertWorker(context: Context,work:WorkerParameters):Worker(context,work){
        override fun doWork(): Result {
            var d=  iv_picture.drawable
            var bd:Bitmap=(d as BitmapDrawable).bitmap
            DbOpenHelper!!.insert(database,0,20200726,1909,bd,tv_memo.text.toString())
            finish()
            return Result.success()
        }

    }
}