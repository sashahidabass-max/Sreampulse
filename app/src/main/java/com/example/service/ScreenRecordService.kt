package com.example.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ScreenRecordService : Service() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        val notification: Notification = NotificationCompat.Builder(this, "screen_record_channel")
            .setContentTitle("Screen Recording")
            .setContentText("Recording in progress...")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .build()
        
        startForeground(1, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "screen_record_channel",
                "Screen Record Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}
