package com.example.tryit.Notifications

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    val CHANNEL_ID1 = "CHANNEL_ID1"
     val CHANNEL_ID2 = "CHANNEL_ID2"
     val CHANNEL_ID3 = "CHANNEL_ID3"
     val CHANNEL_ID4 = "CHANNEL_ID4"
     val CHANNEL_ID5 = "CHANNEL_ID5"

    @SuppressLint("WrongConstant")
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

        val channel3 =
            NotificationChannel(
                CHANNEL_ID3,
                "Channel 3",
                NotificationManager.IMPORTANCE_MAX
            )
        channel3.description = "this my max important channel from Notification"

        val channel4 = NotificationChannel(
            CHANNEL_ID4,
            "Channel 4",
            NotificationManager.IMPORTANCE_MIN
        )
        channel4.description = "this my min important channel from Notification"


        val channel5 = NotificationChannel(
            CHANNEL_ID5,
            "Channel 5",
            NotificationManager.IMPORTANCE_LOW
        )
        channel5.description = "this my low important channel from Notification"


        //create notification manager
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        manager.createNotificationChannel(channel1)
        manager.createNotificationChannel(channel2)
        manager.createNotificationChannel(channel3)
        manager.createNotificationChannel(channel4)
        manager.createNotificationChannel(channel5)


    }


}