package com.example.day10_task.fragment

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.day10_task.roomdb.Spend
import com.example.day10_task.roomdb.SpendRoomDatabase
import com.example.day10_task.databinding.FragmentThuBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ThuFragment(val applicationContext: Context) : Fragment() {
    private val binding by lazy { FragmentThuBinding.inflate(layoutInflater) }
    private val calendar: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val spendRoomDatabase by lazy { SpendRoomDatabase.getDatabase(this) }

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
        binding.icChiTieuHangNgay.setOnClickListener {
            setCategory("Chi tiêu hàng ngày")
        }
        binding.icQAMyPham.setOnClickListener {
            setCategory("Quần áo, mỹ phẩm")
        }
        binding.icPhiGiaoLuu.setOnClickListener {
            setCategory("Phí giao lưu")
        }
        binding.icYTe.setOnClickListener {
            setCategory("Y tế")
        }
        binding.icHocTap.setOnClickListener {
            setCategory("Học tập")
        }
        binding.icDiLai.setOnClickListener {
            setCategory("Đi lại")
        }
        binding.icLienLac.setOnClickListener {
            setCategory("Liên lạc")
        }
        binding.icTienDienNha.setOnClickListener {
            setCategory("Tiền điện, nhà")
        }

        // CLick btn Save
        binding.btnSave.setOnClickListener {
            val time = binding.tvDate.text.toString()
            val note = binding.edGhiChu.text.toString()
            val money = binding.edTienChi.text.toString()
            val detail = binding.txtDanhMuc.text.toString()

            if (time.isNotEmpty() && note.isNotEmpty() && money.isNotEmpty() && detail.isNotEmpty()) {
                val spend = Spend(
                    ngaytao = time,
                    ghichu = note,
                    tienchi = money.toInt(),
                    danhmuc = detail
                )

                Toast.makeText(context, "done", Toast.LENGTH_LONG).show()
                CoroutineScope(Dispatchers.IO).launch {
                    spendRoomDatabase.spendDao().addSpend(spend)
                }
            } else {
                Toast.makeText(
                    context,
                    "Ghi chú, tiền chi, danh mục không được để trống",
                    Toast.LENGTH_LONG
                ).show()
            }
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
        binding.txtDanhMuc.text = category
    }
}