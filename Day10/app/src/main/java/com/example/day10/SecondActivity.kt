package com.example.day10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.day10.databinding.ActivitySecondBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    private val auth = Firebase.auth
    private val database = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnShowUserList.setOnClickListener {
            database.collection("user")
                .get()
                .addOnSuccessListener { documents ->
                    val userList = mutableListOf<User>()
                    for(document in documents){
                        val user = document.toObject<User>()
                        userList.add(user)
                    }
                    println(userList)
                }
                .addOnFailureListener {

                }
        }

        binding.btnSave.setOnClickListener {
            auth.currentUser?.let { user ->
                val userr = User(
                    username = binding.edUserName.text.toString(),
                    age = binding.edAge.text.toString().toInt(),
                    address = binding.edAddress.text.toString()
                )

                database.collection("user")
                    .document(user.uid)
                    .set(userr)
                    .addOnSuccessListener {
                    }
            }

        }

        auth.currentUser?.let { user ->
            database.collection("user")
                .document(user.uid)
                .get()
                .addOnSuccessListener { document ->
                    val user = document.toObject<User>()

                    binding.edUserName.setText(user?.username.toString())
                    binding.edAddress.setText(user?.address.toString())
                    binding.edAge.setText(user?.age.toString())
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, exception.message, Toast.LENGTH_LONG).show()
                }
        }

        binding.btnLogOut.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.btnClearText.setOnClickListener {
            binding.edUserName.clearText()
        }
    }
}