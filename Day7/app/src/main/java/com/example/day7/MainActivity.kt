package com.example.day7

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.day7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val allNoteFragment = AllNoteFragment()
    private val favouriteFragment = favouriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.btnFragment1.setOnClickListener{
            supportFragmentManager.commit{
                replace(binding.fragMainScreen.id, allNoteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragMainScreen.id, favouriteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnAddNote.setOnClickListener{
            val intent = Intent(this, AddNoteScreen::class.java)
            startActivity(intent)
        }
    }
}