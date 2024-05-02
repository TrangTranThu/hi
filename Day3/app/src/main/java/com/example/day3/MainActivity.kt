package com.example.day3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tìm view
        val btnClickMe: Button = findViewById(R.id.btnClickMe)

        btnClickMe.setOnClickListener {
//            Toast.makeText(this, "Đây nè", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)

            // set data to pass
            // find edit_text
            val edSendMess: EditText = findViewById(R.id.edSendMess)
            // get data
            val txtData = edSendMess.text.toString()
            intent.putExtra("Mess", txtData)

            startActivity(intent)
        }
    }
}