package com.example.day3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // get data
        val txtData = intent.getStringExtra("Mess")
        val tvReceiveMess: TextView = findViewById(R.id.tvReceiveMess)
        tvReceiveMess.setText(txtData)


//        val user: User? = intent.getParcelableExtra("user")
//        if (user != null) {
//            textout.text = user.username
//        }
    }
}