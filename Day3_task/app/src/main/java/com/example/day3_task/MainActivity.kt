package com.example.day3_task

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentNumber = ""
    private var firstOperand = 0.0
    private var operator = ""

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val btnNumberZero: AppCompatImageButton = findViewById(R.id.number_zero)
        val btnNumberOne: AppCompatImageButton = findViewById(R.id.number_one)
        val btnNumberTwo: AppCompatImageButton = findViewById(R.id.number_two)
        val btnNumberThree: AppCompatImageButton = findViewById(R.id.number_three)
        val btnNumberFour: AppCompatImageButton = findViewById(R.id.number_four)
        val btnNumberFive: AppCompatImageButton = findViewById(R.id.number_five)
        val btnNumberSix: AppCompatImageButton = findViewById(R.id.number_six)
        val btnNumberSeven: AppCompatImageButton = findViewById(R.id.number_seven)
        val btnNumberEight: AppCompatImageButton = findViewById(R.id.number_eight)
        val btnNumberNine: AppCompatImageButton = findViewById(R.id.number_nine)

        val btnAdd: AppCompatImageButton = findViewById(R.id.btn_add)
        val btnMinus: AppCompatImageButton = findViewById(R.id.btn_minus)
        val btnMulti: AppCompatImageButton = findViewById(R.id.btn_multi)
        val btnDiv: AppCompatImageButton = findViewById(R.id.btn_div)
        val btnEqual: AppCompatImageButton = findViewById(R.id.btn_equal)

        btnNumberZero.setOnClickListener {
            appendNumber("0")
        }
        btnNumberOne.setOnClickListener {
            appendNumber("1")
        }
        btnNumberTwo.setOnClickListener {
            appendNumber("2")
        }
        btnNumberThree.setOnClickListener {
            appendNumber("3")
        }
        btnNumberFour.setOnClickListener {
            appendNumber("4")
        }
        btnNumberFive.setOnClickListener {
            appendNumber("5")
        }
        btnNumberSix.setOnClickListener {
            appendNumber("6")
        }
        btnNumberSeven.setOnClickListener {
            appendNumber("7")
        }
        btnNumberEight.setOnClickListener {
            appendNumber("8")
        }
        btnNumberNine.setOnClickListener {
            appendNumber("9")
        }
    }

    // nhập số đầu tiên
    private fun appendNumber(number: String) {
        currentNumber += number
        resultTextView.text = currentNumber
    }


//    private fun performOperation(op: String) {
//        if (currentNumber.isNotEmpty()) {
//            firstOperand = currentNumber.toDouble()
//            operator = op
//            currentNumber = ""
//        }
//    }
}

//        // Tương tự cho các nút số từ 1 đến 9 và nút chấm (buttonDot)
//
//        btnAdd.setOnClickListener {
//            performOperation("+")
//        }
//
//        // Tương tự cho các nút phép tính trừ, nhân, chia
//
//        btnEqual.setOnClickListener {
//            calculateResult()
//        }
//
////        buttonClear.setOnClickListener {
////            clearCalculator()
////        }



//
//    private fun calculateResult() {
//        if (currentNumber.isNotEmpty()) {
//            val secondOperand = currentNumber.toDouble()
//            var result = 0.0
//
//            when (operator) {
//                "+" -> result = firstOperand + secondOperand
//                "-" -> result = firstOperand - secondOperand
//                "*" -> result = firstOperand * secondOperand
//                "/" -> result = firstOperand / secondOperand
//            }
//
//            currentNumber = result.toString()
//            resultTextView.text = currentNumber
//        }
//    }
//
//    private fun clearCalculator() {
//        currentNumber = ""
//        firstOperand = 0.0
//        operator = ""
//        resultTextView.text = "0"
//    }

