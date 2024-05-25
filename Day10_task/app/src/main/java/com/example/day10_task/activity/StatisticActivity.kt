package com.example.day10_task.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day10_task.R
import com.example.day10_task.databinding.ActivityStatisticBinding
import com.example.day10_task.recyclerview.News
import com.example.day10_task.recyclerview.NewsAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class StatisticActivity : AppCompatActivity() {
    private val binding by lazy { ActivityStatisticBinding.inflate(layoutInflater) }
    private val calender: Calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("MM/yyyy", Locale.getDefault())
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

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


        //recyclerView
        imageId = arrayOf(
            R.drawable.ic_food,
            R.drawable.ic_daily_spend,
            R.drawable.ic_clothes,
            R.drawable.ic_exchange,
            R.drawable.ic_medical,
            R.drawable.ic_education,
            R.drawable.ic_transport,
            R.drawable.ic_contact,
            R.drawable.ic_electric_bill,
            R.drawable.ic_salary,
            R.drawable.ic_pocket_money,
            R.drawable.ic_bonus,
            R.drawable.ic_side_job,
            R.drawable.ic_investment,
            R.drawable.ic_extra,

            )
        heading = arrayOf(
            "Ăn uống",
            "Chi tiêu hàng ngày",
            "Quần áo, mỹ phẩm",
            "Phí giao lưu",
            "Y tế",
            "Học tập",
            "Đi lại",
            "Liên lạc",
            "Tiền điện, nhà",
            "Tiền lương",
            "Tiền phụ cấp",
            "Tiền thưởng",
            "Thu nhập phụ",
            "Đầu  từ",
            "Thu nhập tạm"
        )
        newRecyclerView = findViewById(R.id.recycerViewStatistic)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newArrayList = arrayListOf<News>()
        getUserData()

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

    private fun getUserData() {
        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }
        newRecyclerView.adapter = NewsAdapter(newArrayList)
    }

}
