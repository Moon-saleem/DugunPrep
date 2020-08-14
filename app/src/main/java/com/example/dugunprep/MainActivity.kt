package com.example.dugunprep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start_btn.setOnClickListener {

            val moveToSelection= Intent(this,WorkSelection::class.java)
            startActivity(moveToSelection)
        }
    }
}