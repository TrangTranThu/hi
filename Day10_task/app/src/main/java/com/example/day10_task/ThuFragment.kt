package com.example.day10_task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.day10_task.databinding.FragmentThuBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

class ThuFragment(val applicationContext: Context) : Fragment() {
    private val binding by lazy { FragmentThuBinding.inflate(layoutInflater) }
    private val spendRoomDatabase by lazy { SpendRoomDatabase.getDatabase(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSave.setOnClickListener {
            val spend = Spend(
                ngaytao = System.currentTimeMillis(),
                ghichu = binding.edGhiChu.text.toString(),
                tienchi = binding.edTienChi.text.toString().toInt(),
                danhmuc = true,

            )
            Toast.makeText(context, "done", Toast.LENGTH_LONG).show()
            CoroutineScope(Dispatchers.IO).launch {
                spendRoomDatabase.spendDao().addSpend(spend)
            }
        }
    }
}