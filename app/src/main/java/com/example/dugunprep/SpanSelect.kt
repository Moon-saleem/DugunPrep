package com.example.dugunprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_work_selection.*

class SpanSelect : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_span_select)

        var quesation_text=findViewById<TextView>(R.id.question1)
        var option1=findViewById<Button>(R.id.option1)
        var option2=findViewById<Button>(R.id.option2)
        var option3=findViewById<Button>(R.id.option3)
        var next_btn=findViewById<Button>(R.id.next_btn)

        next_btn.setOnClickListener {
            val movetonext  = Intent(this,sprintActivity::class.java)
            startActivity(movetonext)
        }

    }
    fun option1Selected(view: View) {
        view.setBackgroundResource(R.drawable.login_button_background)
        setBackgroundColor()
        setTwentyMinute()
    }

    private fun setTwentyMinute() {
        var intent=Intent(this,sprintActivity::class.java)
        intent.putExtra("Time",40)
        startActivity(intent)

    }

    private fun setBackgroundColor() {

        option2.setBackgroundResource(R.drawable.button_background)
        option3.setBackgroundResource(R.drawable.button_background)

    }


    fun option2Selected(view: View) {
        view.setBackgroundResource(R.drawable.login_button_background)
        setBackgroundColor2()

    }


    private fun setBackgroundColor2() {
        option1.setBackgroundResource(R.drawable.button_background)
        option3.setBackgroundResource(R.drawable.button_background)
    }

    fun option3Selected(view: View) {
        view.setBackgroundResource(R.drawable.login_button_background)
        setBackgroundColor3()
    }

    private fun setBackgroundColor3() {
        option1.setBackgroundResource(R.drawable.button_background)
        option2.setBackgroundResource(R.drawable.button_background)
    }
    }
