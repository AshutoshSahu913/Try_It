package com.example.tryit.Notifications

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    private val CHANNEL_ID1 = "CHANNEL_ID1"
    private val CHANNEL_ID2 = "CHANNEL_ID2"

    override fun onCreate() {
        super.onCreate()
        val channel1 =
            NotificationChannel(
                CHANNEL_ID1,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
        channel1.description = "this my high important channel from Notification"

        val channel2 = NotificationChannel(
            CHANNEL_ID2,
            "Channel 2",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel2.description = "this my Default important channel from Notification"


        //create notification manager
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        manager.createNotificationChannel(channel1)
        manager.createNotificationChannel(channel2)


    }


}