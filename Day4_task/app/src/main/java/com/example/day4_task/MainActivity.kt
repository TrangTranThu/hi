package com.example.day4_task

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.day4_task.databinding.ActivityMainBinding
import com.example.day4_task.model.User

private const val TAG = "HomeActivity"

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogIn.setOnClickListener {
            val isCheckRememberMe: Boolean = binding.cbRememberMe.isChecked
            val ctEmail = binding.edEmail.text.toString()
            val ctPassword = binding.edPassword.text.toString()

            for (user in Data.userList) {
                if (user.email.equals(ctEmail) && user.password.equals(ctPassword)) {
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("isCheckRememberMe", isCheckRememberMe)
                    startActivity(intent)
                    return@setOnClickListener
                }
            }

            Toast.makeText(this, "Địa chỉ email hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show()
        }

        // Click text sign up
        binding.tvSignUp.setOnClickListener {
            val intent: Intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}