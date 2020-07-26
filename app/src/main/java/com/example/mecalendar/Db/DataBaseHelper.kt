package com.example.mecalendar.Db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.mecalendar.Data.MemoData
import java.io.ByteArrayOutputStream

public val DATABASE_NAME:String="memo.db"
public  val DATABASE_VERSION:Int=1
class DataBaseHelper : SQLiteOpenHelper {


    val TABLE_NAME="memotb"
    val COL_ID="id"
    val COL_DATE:String="date"
    val COL_TIME:String="time"
    val COL_IMAGE="image"
    val COL_MEMO="memo"
    val DATABASE_CREATE="create table "+TABLE_NAME+"("+COL_ID+"integer primary key autoincrement, " +
            ""+COL_DATE+" integer, "+
            ""+COL_TIME+" integer, "+
            ""+COL_IMAGE+" blob, "+
            ""+COL_MEMO +" text);"

    constructor(
        context: Context?
    ) : super(context, DATABASE_NAME, null, DATABASE_VERSION){

    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
        db!!.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME)
        db!!.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
        db!!.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME)
        onCreate(db)
    }
    fun insert(db:SQLiteDatabase?,id:Int,date:Int,time:Int,image:Bitmap,memo:String):Boolean{
           var value:ContentValues= ContentValues()
        value.put(COL_DATE,date)
        value.put(COL_TIME,time)
        var stream:ByteArrayOutputStream=ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG,100,stream)
        var bytearray:ByteArray=stream.toByteArray()
        value.put(COL_IMAGE,bytearray)
        value.put(COL_MEMO,memo)
        db!!.insert(TABLE_NAME,null,value)
        return true
    }
    fun select(db:SQLiteDatabase?,date:Int):ArrayList<MemoData>{
        var mdatalist= arrayListOf<MemoData>()
        var cursor:Cursor=db!!.rawQuery("SELECT*FROM "+TABLE_NAME+"WHERE date="+date,null)
    while (cursor.moveToNext()){
         var date=cursor.getInt(1)
        var time=cursor.getInt(2)
        var bitmapbyte=cursor.getBlob(3)
        var bitmap=BitmapFactory.decodeByteArray(bitmapbyte,0,bitmapbyte.size)
        var memo=cursor.getString(4)
        var mdata=MemoData()
        mdata.time=date.toString()+time.toString()
        mdata.image=bitmap
        mdata.memo=memo
        mdatalist.add(mdata)
    }
        return mdatalist
    }
}