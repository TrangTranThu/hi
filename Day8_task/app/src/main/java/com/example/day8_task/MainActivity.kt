package com.example.day8_task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.day8_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val allNoteFragment = AllNoteFragment()
    private val favouriteNoteFragment = FavouriteNoteFragment()
    private lateinit var noteDB: NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fv.id, allNoteFragment)
        }

        binding.tvTextNote.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fv.id, allNoteFragment)
            }
        }

        binding.tvFavourite.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fv.id, favouriteNoteFragment)
            }
        }

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
    }
//    override fun onResume() {
//        super.onResume()
//        allNoteFragment.refreshNoteList()
//    }
}