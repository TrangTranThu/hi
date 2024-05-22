package com.example.day10_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.day10_task.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val thuFragment = ThuFragment(this)
    private val chiFragment = ChiFragment()

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
    }
}