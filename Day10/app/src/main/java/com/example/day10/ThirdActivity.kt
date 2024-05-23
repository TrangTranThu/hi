package com.example.day10

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day10.databinding.ActivityThirdBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }
    private val database = Firebase.firestore
    private val userAdapter = UserAdapter {
        onItemClick(it)
    }

    private fun onItemClick(view: TextView) {
        Toast.makeText(this, view.text, Toast.LENGTH_LONG).show()
    }

//    private val userList = mutableListOf(
//        User("Trần Thu Trang", "A", 21),
//        User("Trần Thu Trang A", "B", 22),
//        User("Trần Thu Trang B", "C", 23),
//        User("Trần Thu Trang C", "D", 24)
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = userAdapter

        database.collection("user")
            .get()
            .addOnSuccessListener { documents ->
                val userList = mutableListOf<User>()
                for (document in documents) {
                    val userr = document.toObject<User>()
                    userList.add(userr)
                }
//                binding.recyclerView.adapter = UserAdapter(userList)
            }
        database.collection("user")
            .addSnapshotListener { value, error ->
                val userList = mutableListOf<User>()
                if (value != null) {
                    for (document in value) {
                        val userr = document.toObject<User>()
                        userList.add(userr)
                    }
                }
                userAdapter.setList(userList)
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            }
    }
}

// Extension Function