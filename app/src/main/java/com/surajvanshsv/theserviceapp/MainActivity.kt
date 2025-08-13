package com.surajvanshsv.theserviceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.playRingtone)
        val stopBtn = findViewById<Button>(R.id.stopRingtone)

        startBtn.setOnClickListener {
            // starting the service
            val startServiceIntent  = Intent(
                applicationContext,
                MyService::class.java
            )

            startService(startServiceIntent)
        }

        stopBtn.setOnClickListener {
            val stopServiceIntent = Intent(
                applicationContext,
                MyService::class.java
            )
            stopService(stopServiceIntent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}