package com.example.mecalendar

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timer

class IntroActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity);
        val i  =Intent(this,MainActivity::class.java)
        val timer=timer(period=5000){

            startActivity(i)
            finish()
            cancel()
        }

    }
}