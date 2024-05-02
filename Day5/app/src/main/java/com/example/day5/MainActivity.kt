package com.example.day5

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.example.day5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    var fullName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

//        Glide.with(this).load("https://userscontent2.emaze.com/images/414b3fd0-6210-4a61-8d8b-00a1a941c0fc/554fe7cf840e80e75326cc07a48273bd.jpg").into(binding.img)
        binding.btnFragment1.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, firstFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnFragment2.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, secondFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnReceive.setOnClickListener{
//            binding.tvMain.text = firstFragment.fullname
            fullName = binding.edMain1.text.toString()
        }
    }
}