package com.example.day3_task

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class MainActivity : AppCompatActivity() {

    private var number: String = ""
    private lateinit var tvResult: TextView
    private var firstNumber: Int = 0
    private var operator: Char = ' '

    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        val btnCleaner: AppCompatImageButton = findViewById(R.id.del_btn)

        tvResult  = findViewById(R.id.textViewResult)

        btnNumberZero.setOnClickListener {
            numberClick("0")
        }
        btnNumberOne.setOnClickListener {
            numberClick("1")
        }
        btnNumberTwo.setOnClickListener {
            numberClick("2")
        }
        btnNumberThree.setOnClickListener {
            numberClick("3")
        }
        btnNumberFour.setOnClickListener {
            numberClick("4")
        }
        btnNumberFive.setOnClickListener {
            numberClick("5")
        }
        btnNumberSix.setOnClickListener {
            numberClick("6")
        }
        btnNumberSeven.setOnClickListener {
            numberClick("7")
        }
        btnNumberEight.setOnClickListener {
            numberClick("8")
        }
        btnNumberNine.setOnClickListener {
            numberClick("9")
        }

        btnAdd.setOnClickListener() {
            operatorClick('+')
        }
        btnMinus.setOnClickListener() {
            operatorClick('-')
        }
        btnMulti.setOnClickListener() {
            operatorClick('*')
        }
        btnDiv.setOnClickListener() {
            operatorClick('/')
        }

        btnEqual.setOnClickListener() {
            equalClick()
        }
        btnCleaner.setOnClickListener(){
            clearCalculator()
        }
    }
    //click button number
    private fun numberClick(n: String) {
        number += n
        tvResult.text = number
    }

    //click button operator
    private fun operatorClick(op: Char) {
        if (number.isNotEmpty()) {
            firstNumber = number.toInt()
            number = ""
            operator = op
            tvResult.text = firstNumber.toString()
        }
    }

    //Display result
    private fun equalClick() {
        if (number.isNotEmpty() && operator != ' ') {
            val secondNumber = number.toDouble()
            var result = 0.0
            when (operator) {
                '+' -> result = firstNumber + secondNumber
                '-' -> result = firstNumber - secondNumber
                '*' -> result = firstNumber * secondNumber
                '/' -> {
                    if (secondNumber != 0.0) {
                        result = firstNumber / secondNumber
                    }
                }
            }

            // Check if result is integer or not
            val isIntegerResult = (result % 1 == 0.0)

            if (isIntegerResult) {
                tvResult.text = result.toInt().toString() // Display integer result
            } else {
                tvResult.text = result.toString() // Display floating point result
            }

            number = ""
            operator = ' '
        }
    }


    private fun clearCalculator() {
        number = ""
        firstNumber = 0
        operator = ' '
        tvResult.text = ""
        tvResult.text = ""
    }
}