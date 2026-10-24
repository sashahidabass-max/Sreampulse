package com.example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class FloatingOverlayService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Floating HUD overlay logic
        return START_STICKY
    }
}
