package com.example.day10_task

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.day10_task.databinding.FragmentChiBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ChiFragment : Fragment() {
    private val binding by lazy { FragmentChiBinding.inflate(layoutInflater) }
    private val calendar: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hiển thị ngày tháng năm hiện tại
        updateDateInView()

        // Mở DatePicker khi nhấn vào TextView
        binding.tvDate.setOnClickListener {
            showDatePickerDialog()
        }

        // Lùi ngày khi nhấn vào nút mũi tên trái
        binding.btnPrevious.setOnClickListener {
            calendar.add(Calendar.DAY_OF_MONTH, -1)
            updateDateInView()
        }

        // Tiến ngày khi nhấn vào nút mũi tên phải
        binding.btnNext.setOnClickListener {
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            updateDateInView()
        }

        binding.icAnUong.setOnClickListener {
            setCategory("Ăn uống")
        }
        binding.icTienPhuCap.setOnClickListener {
            setCategory("Tiền phụ cấp")
        }
        binding.icTienThuong.setOnClickListener {
            setCategory("Tiền thưởng")
        }
        binding.icThuNhapPhu.setOnClickListener {
            setCategory("Thu nhập phụ")
        }
        binding.icDauTu.setOnClickListener {
            setCategory("Đầu tư")
        }
        binding.icThuNhapTam.setOnClickListener {
            setCategory("Thu nhập tạm")
        }
    }

    private fun updateDateInView() {
        binding.tvDate.text = dateFormat.format(calendar.time)
    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                updateDateInView()
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    fun setCategory(category: String) {
        binding.txtDanhmuc.text = category
    }
}