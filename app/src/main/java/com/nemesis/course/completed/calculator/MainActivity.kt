package com.nemesis.course.completed.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var display:TextView

    private val processor = Processor()

    private var isTypingANumber:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val btn0:Button = findViewById(R.id.key_0)
        btn0.setOnClickListener(this)

        val btn1:Button = findViewById(R.id.key_1)
        btn1.setOnClickListener(this)

        val btn2:Button = findViewById(R.id.key_2)
        btn2.setOnClickListener(this)

        val btn3:Button = findViewById(R.id.key_3)
        btn3.setOnClickListener(this)

        val btn4:Button = findViewById(R.id.key_4)
        btn4.setOnClickListener(this)

        val btn5:Button = findViewById(R.id.key_5)
        btn5.setOnClickListener(this)

        val btn6:Button = findViewById(R.id.key_6)
        btn6.setOnClickListener(this)

        val btn7:Button = findViewById(R.id.key_7)
        btn7.setOnClickListener(this)

        val btn8:Button = findViewById(R.id.key_8)
        btn8.setOnClickListener(this)

        val btn9:Button = findViewById(R.id.key_9)
        btn9.setOnClickListener(this)

        val btnAdd:Button = findViewById(R.id.key_addition)
        btnAdd.setOnClickListener(this)

        val btnSubs:Button = findViewById(R.id.key_substraction)
        btnSubs.setOnClickListener(this)

        val btnMult:Button = findViewById(R.id.key_multiplication)
        btnMult.setOnClickListener(this)

        val btnDiv:Button = findViewById(R.id.key_division)
        btnDiv.setOnClickListener(this)

        val btnEquals:Button = findViewById(R.id.key_equals)
        btnEquals.setOnClickListener(this)

        val btnClear:Button = findViewById(R.id.key_clear)
        btnClear.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if(view is Button){

            when(view.id){
                R.id.key_addition,
                R.id.key_substraction,
                R.id.key_multiplication,
                R.id.key_division,
                R.id.key_equals -> {
                    performOperation(view.text.toString())
                }

                R.id.key_clear -> {
                    clear()
                }

                else -> {
                    addDigit(view.text.toString())
                }
            }

        }
    }

    private fun addDigit(digit:String){
        if(isTypingANumber){
            val text = display.text.toString() + digit
            display.text = text
        }else{
            isTypingANumber = true
            display.text = digit
        }
    }

    private fun performOperation(symbol:String){

        isTypingANumber = false

        if(!processor.hasFirstOperand()){

            val operand = display.text.toString().toDouble()
            processor.setOperand(operand)
            processor.setOperation(symbol)

        }else {

            val operand = display.text.toString().toDouble()
            processor.performOperation(operand)
            processor.setOperation(symbol)

            showResult()
        }
    }

    private fun showResult(){
        display.text = processor.getResult().toString()
    }

    private fun clear(){
        display.text = "0"
        processor.clear()
    }

}
