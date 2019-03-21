package com.example.a8_multimedia

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mediaFile =
            File("${Environment.getExternalStorageDirectory().getAbsolutePath()}/Music/mb/Electronic/Getting Away With It/gettingawaywithitreal.m4a")
        val player = MediaPlayer()

        player.setOnPreparedListener { mp ->

            Play.setOnClickListener {
                mp.start()
            }

            Pause.setOnClickListener {
                mp.pause()
            }
        }
        player.setAudioStreamType(AudioManager.STREAM_MUSIC)
        player.setDataSource(applicationContext, Uri.fromFile(mediaFile))
        player.prepareAsync()
    }
}
