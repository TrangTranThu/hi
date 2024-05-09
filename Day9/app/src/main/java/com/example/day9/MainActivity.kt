package com.example.day9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.day9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    //    private val noteList = mutableListOf(
//        Note(
//            "Trần Thu Trang",
//            21,
//            "g"
//        ),
//        Note(
//            "Trần Thu Trang",
//            21,
//            "Bg"
//        ),
//        Note(
//            "Trần Thu Trang",
//            21,
//            "B"
//        )
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.rvNote.adapter = NoteAdapter(noteList)
//        binding.rvNote.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        val apiService = RetrofitClient.getInstance().create(APIService::class.java)
//        apiService.getAllStudents().enqueue(object : Callback<List<Note>> {
//            override fun onResponse(call: Call<List<Note>>, response: Response<List<Note>>) {
//                if (response.isSuccessful) {
////                    binding.rvNote.adapter = NoteAdapter(response.body())
//                } else {
//                    Toast.makeText(this@MainActivity, "hihi", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<List<Note>>, t: Throwable) {
//            }
//
//        }
//        )

        val apiService = RetrofitClient.getInstance().create(APIService::class.java)
        binding.btnFind.setOnClickListener {
            val id = binding.edId.text.toString()
            apiService.getStudentById(id).enqueue(object : Callback<Note> {
                override fun onResponse(call: Call<Note>, response: Response<Note>) {
                    if (response.isSuccessful) {
                        val student = response.body()
                        with(binding) {
                            tvName.text = student?.name
                            tvAge.text = student?.age.toString()
                            tvAddress.text = student?.address
                        }
                    } else {
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                override fun onFailure(call: Call<Note>, t: Throwable) {
                }

            }
            )
        }
        binding.btnCreate.setOnClickListener {
            val note = Note(
                id = "hihi",
                name = "Trang ne",
                age = 21,
                address = "Bg"
            )
            apiService.createStudent(note).enqueue(object : Callback<Note> {
                override fun onResponse(call: Call<Note>, response: Response<Note>) {
                    Toast.makeText(this@MainActivity, "otoce", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Note>, t: Throwable) {
                }
            }
            )
        }
    }
}