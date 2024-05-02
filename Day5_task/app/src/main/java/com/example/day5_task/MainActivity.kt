package com.example.day5_task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.day5_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val homeFragment = HomeFragment()
    private val profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, homeFragment)
            setReorderingAllowed(true)
        }
        binding.btnProfile.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, profileFragment)
                setReorderingAllowed(true)
            }
        }
        binding.btnHome.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, homeFragment)
                setReorderingAllowed(true)
            }
        }
    }
}