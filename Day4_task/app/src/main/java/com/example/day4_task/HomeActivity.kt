package com.example.day4_task

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day4_task.databinding.ActivityHomeBinding
import com.example.day4_task.model.User
import com.example.day4_task.view.UserAdapter

//private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private lateinit var userList: MutableList<User>
    private lateinit var userAdapter: UserAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        check rememberme
//        val isCheckRememberMe = intent.getBooleanExtra("isCheckRememberMe", false)
//        if (isCheckRememberMe) {
//            Toast.makeText(this, "Saved passwords", Toast.LENGTH_LONG).show()
//        }

//        Log.e(TAG, "onCreate: $ctYourName", )
        binding.mRecycler.adapter = UserAdapter(Data.userList)
        binding.mRecycler.layoutManager = LinearLayoutManager(this)

        // button log out
        binding.btnLogout.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}



