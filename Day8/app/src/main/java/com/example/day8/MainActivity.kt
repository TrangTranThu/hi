package com.example.day8

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day8.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAddNote.setOnClickListener{
            val note = Note(
                title = binding.edTitle.text.toString(),
                content = binding.edContent.text.toString(),
                check = binding.edCheck.text.toString()
            )

            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().addNote((note))
            }
        }

        binding.btnShowNote.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                println( noteRoomDatabase.noteDao().getAllNote())
            }
        }
    }
}