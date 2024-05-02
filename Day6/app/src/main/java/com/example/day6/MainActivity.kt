package com.example.day6

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.day6.databinding.ActivityMainBinding
import com.example.day6.databinding.DialoggBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val alertDialog = AlertDialog.Builder(this)

        alertDialog
            .setTitle("Hello")
            .setMessage("everyone")
            .setView(R.layout.dialogg)
            .setPositiveButton("Ok") { _, _ ->

                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Nega") { _, _ ->
                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Neu") { _, _ ->
                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show()
            }

        val dialog = Dialog(this)
        val dialogBinding = DialoggBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        binding.btnClick.setOnClickListener {
            dialog.show()
            binding.tvInfo.text =
                dialogBinding.edName.text.toString() + dialogBinding.edEmail.text.toString()

        }

//        binding.btnClick.setOnClickListener{
////            alertDialog.show()
//            dialog.show()
//
//        }
    }
}