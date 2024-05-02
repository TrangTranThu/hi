package com.example.day4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // private lateinit var  binding: ActivityMainBinding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val list = mutableListOf(
        User("hihi", "1"),
        User("helo", "2"),
        User("hi", "3"),
        User("kkk", "4"),
    )
    private val userAdapter = UserAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClickMe.setOnClickListener {
            Toast.makeText(this, "HEllO", Toast.LENGTH_SHORT).show()
        }

        binding.btnDontCLickMe.setOnClickListener {

        }

        binding.recycler.adapter = userAdapter
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.recycler.layoutManager = LinearLayoutManager(this)
//        binding.recycler.layoutManager = GridLayoutManager(this, 2)
    }
}