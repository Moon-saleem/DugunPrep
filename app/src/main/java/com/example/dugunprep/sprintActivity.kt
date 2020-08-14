package com.example.dugunprep

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Window
import android.widget.*
import kotlinx.android.synthetic.main.activity_sprint.*
import kotlinx.android.synthetic.main.tutors_score.*
import java.lang.String
import kotlin.concurrent.timer

class sprintActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sprint)
        var btn_play: ImageView = findViewById<ImageView>(R.id.play_btn)
        var mp: MediaPlayer = MediaPlayer.create(this, R.raw.ring)

        btn_play.setOnClickListener {
            if (mp.isPlaying())
            {

                btn_play.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
                mp.pause()
            }
            else{
                btn_play.setImageResource(R.drawable.ic_baseline_pause_24)
                mp.start()
            }
        }

        start_sprint_btn.setOnClickListener {
            showDialog()
        }




        val time=intent.getIntExtra("Time",20)
        var countTime= findViewById<TextView>(R.id.count_time)
        countTime.text=time.toString()
        object : CountDownTimer(21000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.setText(String.valueOf(counter))
                counter++

            }

            override fun onFinish() {
                val intent=Intent(applicationContext,AudioPlayersprint::class.java)
                startActivity(intent)
            }
        }.start()


    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_dialog)
        val messageText = dialog.findViewById(R.id.message_text) as TextView
        val yesBtn = dialog.findViewById(R.id.postive_btn) as Button
        val noBtn = dialog.findViewById(R.id.negative_btn) as Button

        yesBtn.setOnClickListener {
            showSecondDialog()
            dialog.dismiss()

        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showSecondDialog() {
        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.help_dialog)

        val messageText = dialog.findViewById(R.id.second_message_text) as TextView
        val secondyesBtn = dialog.findViewById(R.id.second_postive_btn) as Button
        val secondnoBtn = dialog.findViewById(R.id.second_negative_btn) as Button
        secondyesBtn.setOnClickListener {
            showthirdDialog()
            dialog.dismiss()

        }
        secondnoBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

      }

    private fun showthirdDialog() {
        val dialog= Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.tutors_score)
        val image=dialog.findViewById<ImageView>(R.id.score_image)
        val message=dialog.findViewById<TextView>(R.id.third_message_text)
        val layout=dialog.findViewById<RelativeLayout>(R.id.tutors_Scored)
        layout.setOnClickListener {
            dialog.dismiss()

        }
        dialog.show()



    }
}

