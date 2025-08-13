package com.surajvanshsv.theserviceapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

// service is a component in android that runs in background
// and doesnot have a user interface

class MyService : Service(){

    // to play music , we need a music player object ;
    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
            // return null if binding is not allowed
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        //
        mediaPlayer = MediaPlayer.create(
            this,
            Settings.System.DEFAULT_RINGTONE_URI
        )
        // play the ringtone in loop
        mediaPlayer.isLooping

        // start it
        mediaPlayer.start()


        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}