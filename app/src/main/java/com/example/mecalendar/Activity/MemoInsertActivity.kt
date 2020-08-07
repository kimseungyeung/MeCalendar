package com.example.mecalendar.Activity

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mecalendar.R
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.client.Url
import io.socket.emitter.Emitter
import kotlinx.android.synthetic.main.insert_activity.*
import kotlinx.android.synthetic.main.item_memo.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MemoInsertActivity :AppCompatActivity(), View.OnClickListener {
    var req:RequestQueue?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insert_activity)
        init()
    }
    fun init(){
        req=Volley.newRequestQueue(applicationContext)
        btn_insert.setOnClickListener(this)

    }

    override fun onClick(v: View?){
        when(v!!.id){
            R.id.btn_insert->{
//            var work= OneTimeWorkRequest.Builder(InsertWorker::class.java).build()
//                var start=WorkManager.getInstance(this).enqueue(work)
                CoroutineScope(Dispatchers.IO).launch {
//                    var d=  iv_picture.drawable
//                    var bd:Bitmap?=null
//                         bd = (d as BitmapDrawable).bitmap
//                    DbOpenHelper!!.insert(database,0,20200805,1909,bd!!,edt_memo.text.toString())
//                    finish()
                    volleystart()
                }
            }
        }
    }

    fun starthttpsurlconnection(){
        try{
            var url=URL("https://api.covid19api.com/total/country/korea-south")
           var c=url.openConnection() as HttpsURLConnection
            c.requestMethod="GET"
            c.doInput=true
            c.doOutput=false
            var iss=c.inputStream
            var br=BufferedReader(InputStreamReader(iss,"UTF-8"))
            br.use {
                var d=it.readText()
                var json=JSONArray(d)
                var dd=json.getJSONObject(0).get("Country")

                Log.d("d",d)
            }




        }catch (e:Exception){
            Log.e("error",e.message.toString())
        }
    }

    //socket은 ip 및 포트 입력해서 통신하도록함
        fun socketstart(){
            try{
             var io=IO.socket("https://api.covid19api.com/total/country/korea-south")

                io.on(Socket.EVENT_CONNECT, Emitter.Listener {
                    var d=it.get(0).toString()
                })
                io.on(Socket.EVENT_CONNECT_ERROR, Emitter.Listener {
                   var d = it.get(0).toString()
                })
                io.on(Socket.EVENT_CONNECT_TIMEOUT, Emitter.Listener {
                    var d=it.get(0).toString()
                })
                io.connect()
            }catch (e:Exception){
                Log.e("error",e.message)
            }
        }
    fun volleystart(){
        var url:String?="https://api.covid19api.com/total/country/korea-south"
        var srequest=StringRequest(Request.Method.GET,url, Response.Listener {
            var d=it.reader().readText()
            var ddf=""
        }, Response.ErrorListener {
            Log.e("error",it.message)
        })
        srequest.setShouldCache(false)
        req!!.add(srequest)
    }
}