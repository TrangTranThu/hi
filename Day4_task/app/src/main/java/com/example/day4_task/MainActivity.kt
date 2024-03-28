package com.example.day4_task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn_LogIn: Button = findViewById(R.id.btn_LogIn)
        val tv_SignUp: TextView = findViewById(R.id.tv_SignIn)

        btn_LogIn.setOnClickListener{
            val intent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        tv_SignUp.setOnClickListener{
            val intent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}