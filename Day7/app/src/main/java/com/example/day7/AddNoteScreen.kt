package com.example.day7

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day7.NoteSave.Companion.noteList
import com.example.day7.databinding.ActivityAddNoteScreenBinding
import java.util.Date

class AddNoteScreen : AppCompatActivity() {
    private val binding by lazy { ActivityAddNoteScreenBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnSaveNote.setOnClickListener{
            if(binding.edTitle.text.isNullOrBlank())
                Toast.makeText(this, "Bạn chưa nhập title", Toast.LENGTH_LONG).show()
            if(binding.edContent.text.isNullOrBlank())
                Toast.makeText(this, "Bạn chưa nhập content", Toast.LENGTH_LONG).show()

        }

        binding.icBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnSaveNote.setOnClickListener{
            noteList.add(Note(binding.edTitle.text.toString(), binding.edContent.text.toString(), Date(), false))
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()

    }
}