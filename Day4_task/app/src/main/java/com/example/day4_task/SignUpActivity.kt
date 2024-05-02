package com.example.day4_task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.day4_task.databinding.ActivitySignUpBinding
import com.example.day4_task.model.User

class SignUpActivity : AppCompatActivity() {
    private val bindingSignUp by lazy { ActivitySignUpBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingSignUp.root)

        //Click button Sign Up
        bindingSignUp.btnSignIn.setOnClickListener {
            val ctYourName =
                bindingSignUp.edUserName.text.toString()
            val ctEmail =
                bindingSignUp.edEmail.text.toString()
            val ctPassword =
                bindingSignUp.edPassword.text.toString()
            val ctCfPassword =
                bindingSignUp.edCfPassword.text.toString()

            Data.userList.add(
                User(
                    ctYourName.toString(),
                    ctEmail.toString(),
                    ctPassword.toString()
                )
            )

            val intent: Intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}