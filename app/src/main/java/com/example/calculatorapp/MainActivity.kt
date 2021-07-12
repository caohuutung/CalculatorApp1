package com.example.calculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Xử lý các nút số
        btn0.setOnClickListener { appendVal("0", false) }
        btn1.setOnClickListener { appendVal("1", false) }
        btn2.setOnClickListener { appendVal("2", false) }
        btn3.setOnClickListener { appendVal("3", false) }
        btn4.setOnClickListener { appendVal("4", false) }
        btn5.setOnClickListener { appendVal("5", false) }
        btn6.setOnClickListener { appendVal("6", false) }
        btn7.setOnClickListener { appendVal("7", false) }
        btn8.setOnClickListener { appendVal("8", false) }
        btn9.setOnClickListener { appendVal("9", false) }
        btnDot.setOnClickListener { appendVal(".", false) }

        // Xử lý các phím chức năng
        btnCE.setOnClickListener { appendVal("", true) }
        btnChia.setOnClickListener { appendVal(" / ", false) }
        btnNhan.setOnClickListener { appendVal(" * ", false) }
        btnTru.setOnClickListener { appendVal(" - ", false) }
        btnCong.setOnClickListener { appendVal(" + ", false) }

        btnONC.setOnClickListener {
            tvExpression.text = tvExpression.text.toString().subSequence(0, tvExpression.text.length - 1)
        }

        btnEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    tvExpression.text = longResult.toString()
                } else
                    tvExpression.text = result.toString()

            } catch (e: Exception) {
            }
        }
    }

    fun appendVal(string: String, isClear: Boolean) {
        if (isClear) {
            tvExpression.text = ""
        } else {
            tvExpression.append(string)
        }
    }
}