package com.example.mecalendar.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.mecalendar.R
import kotlin.concurrent.timer

class IntroActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity);
        //ss
        val i  =Intent(this, MainActivity::class.java)
        hh.postDelayed(Runnable {
            startActivity(i)
            finish()

        },5000)
    }

    var hh=Handler()
}