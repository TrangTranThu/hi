package com.example.day8_task

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.day8_task.databinding.ActivityAddNoteBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddNoteBinding.inflate(layoutInflater) }
    private val noteDB by lazy { NoteRoomDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnSaveNote.setOnClickListener {
            val title = binding.edTitle.text.toString()
            val content = binding.edContent.text.toString()

            if (title.isNotBlank() && content.isNotBlank()) {
                CoroutineScope(Dispatchers.IO).launch {
                    noteDB.noteDao().insert(Note(title = title, content = content, check = false))
                }
                Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Title must not be blank!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


