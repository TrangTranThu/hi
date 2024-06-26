package com.example.day10_task.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.day10_task.fragment.ChiFragment
import com.example.day10_task.fragment.ThuFragment
import com.example.day10_task.databinding.ActivityHomeBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val auth = Firebase.auth
    private val thuFragment = ThuFragment(this)
    private val chiFragment = ChiFragment(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragment.id, thuFragment)
        }

        binding.btnThu.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragment.id, thuFragment)
            }
        }

        binding.btnChi.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragment.id, chiFragment)
            }
        }

        binding.btnStatistic.setOnClickListener{
            startActivity(Intent(this, StatisticActivity::class.java))
        }

        binding.btnLogOut.setOnClickListener {
            auth.signOut()
            finishAffinity()
        }
    }
}
