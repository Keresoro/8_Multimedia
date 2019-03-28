package com.example.a8_multimedia

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder

class MusicService: Service(), MediaPlayer.OnPreparedListener {

    var mediaPlayer: MediaPlayer? = null
    //needs to be Null

    inner class MusicServiceBinder : Binder()
    {
        fun getService() : MusicService
        {
            return this@MusicService
        }
    }

    override fun onBind(intent: Intent) : IBinder {

        return MusicServiceBinder()
    }

    override fun onPrepared(mp: MediaPlayer)
    {

        //to control the on prepared...
        // on prepared method, as soon as it is ready to play
    }

}
