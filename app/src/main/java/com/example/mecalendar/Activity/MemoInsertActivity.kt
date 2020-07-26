package com.example.mecalendar.Activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mecalendar.R
import kotlinx.android.synthetic.main.insert_activity.*
import kotlinx.android.synthetic.main.item_memo.*

class MemoInsertActivity :AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insert_activity)
    }
    fun init(){
        btn_insert.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when(v!!.id){
            R.id.btn_insert->{

              var d=  iv_picture.drawable
                var bd:Bitmap=(d as BitmapDrawable).bitmap
            DbOpenHelper!!.insert(database,0,20200726,1909,bd,tv_memo.text.toString())
            }
        }
    }
}