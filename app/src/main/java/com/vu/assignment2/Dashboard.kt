package com.vu.assignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Dashboard: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set layout to profile
        setContentView(R.layout.dashboard)
        //Get username & password
        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")
    }
}