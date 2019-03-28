package com.example.a8_multimedia

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var service: Service? = null

        val startIntent = Intent(this, MusicService::class.java)
        startService(startIntent) //service connection

        val serviceConn = object: ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                service = ((binder as MusicService.MusicServiceBinder).getService())

                mediaPlayer.setOnPreparedListener

            }

            override fun onServiceDisconnected(name: ComponentName?) {
            }
        }
        val bindIntent = Intent(this, MusicService::class.java);
        bindService(bindIntent, serviceConn,  Context.BIND_AUTO_CREATE)

        val mediaFile =
            File("${Environment.getExternalStorageDirectory().getAbsolutePath()}/Music/3D_Printer_Slow_Edit_for_Android.mp3")
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
