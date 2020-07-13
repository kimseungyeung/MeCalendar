package com.example.mecalendar.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mecalendar.R
import kotlin.concurrent.timer

class IntroActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity);
        val i  =Intent(this, MainActivity::class.java)
        val timer=timer(period=5000){

            startActivity(i)
            finish()
            cancel()
        }

    }
}