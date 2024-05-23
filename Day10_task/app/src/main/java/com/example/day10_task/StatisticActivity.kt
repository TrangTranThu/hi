package com.example.day10_task

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.day10_task.databinding.ActivityStatisticBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class StatisticActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStatisticBinding.inflate(layoutInflater) }
    private val calender: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("MM/yyyy", Locale.getDefault())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Hiển thị tháng năm hiện tại
        updateDateInView()

        // Mở DatePicker khi nhấn vào TextView
        binding.tvDate.setOnClickListener {
            showDatePickerDialog()
        }
        // Lùi ngày khi nhấn vào nút mũi tên trái
        binding.btnPrevious.setOnClickListener {
            calender.add(Calendar.MONTH, -1)
            updateDateInView()
        }

        // Tiến ngày khi nhấn vào nút mũi tên phải
        binding.btnNext.setOnClickListener {
            calender.add(Calendar.MONTH, 1)
            updateDateInView()
        }
    }

    private fun updateDateInView() {
        binding.tvDate.text = dateFormat.format(calender.time)
    }

    private fun showDatePickerDialog() {
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, _ ->
                calender.set(selectedYear, selectedMonth, day)
                updateDateInView()
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }
}
