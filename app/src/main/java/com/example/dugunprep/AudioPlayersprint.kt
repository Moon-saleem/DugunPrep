package com.example.dugunprep

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.String

class AudioPlayersprint : AppCompatActivity() {
    var counter = 0

     private var my_main_arrayList = ArrayList<Music>()
     private var mymusicAdapter:MusicAdapter?=null
     private var list_view_songs:ListView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_playersprint)
        list_view_songs=findViewById(R.id.audio_listview)
        my_main_arrayList= ArrayList()
        my_main_arrayList.add(Music(R.raw.ring))
        my_main_arrayList.add(Music(R.raw.tum))
        my_main_arrayList.add(Music(R.raw.tum_mujhko_kab_tak_rokoge))


        mymusicAdapter=MusicAdapter(this,R.layout.audio_item_layout,my_main_arrayList)
        list_view_songs!!.adapter=mymusicAdapter

        var countTime= findViewById<TextView>(R.id.count_time)
        object : CountDownTimer(51000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countTime.setText(String.valueOf(counter))
                counter++

            }

            override fun onFinish() {
//                counttime.setText("Finished")
            }
        }.start()



    }
}