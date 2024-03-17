package com.example.tryit.Notifications

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tryit.R
import com.example.tryit.databinding.ActivityNotificationBinding

class Notification : AppCompatActivity() {
    val binding: ActivityNotificationBinding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }

    @SuppressLint("ResourceAsColor", "LaunchActivityFromNotification")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.high.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID1)
            notification.setContentTitle(binding.ed1.text.toString())
            notification.setContentText(binding.ed2.text.toString())

            val intent = Intent(this, BroadCast::class.java)
            intent.putExtra("DATA_SEND", binding.ed2.text.toString())

            val pendingIntent =
                PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            val intent2 = Intent(this, NextActivity::class.java)
            intent2.putExtra("Data_send", binding.ed2.text.toString())
            val pendingIntent2 =
                PendingIntent.getActivity(this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            notification.setSmallIcon(R.drawable.notification_svgrepo_com)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent2)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(R.color.appColor)
                .setOnlyAlertOnce(true)
                .addAction(R.drawable.notification_svgrepo_com, "reply", pendingIntent)
                .addAction(R.drawable.notification_svgrepo_com, "message", pendingIntent2)
                .addAction(R.drawable.notification_svgrepo_com, "clear", pendingIntent)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1, notification.build())

        }

        binding.Default.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID2)
            notification.setContentTitle(binding.ed1.text.toString())
            notification.setContentText(binding.ed2.text.toString())


            val intent = Intent(this, BroadCast::class.java)
            intent.putExtra("DATA_SEND_2", binding.ed2.text.toString())

            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)


            notification.setSmallIcon(android.R.drawable.star_big_on)
            notification.setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(R.drawable.notification_svgrepo_com, "reply", pendingIntent)
                .addAction(R.drawable.notification_svgrepo_com, "message", pendingIntent)
                .addAction(R.drawable.notification_svgrepo_com, "clear", pendingIntent)
                .setCategory(NotificationCompat.CATEGORY_ALARM)
                .setColor(Color.GREEN)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .addAction(R.drawable.notification_svgrepo_com, "reply", null)
                .addAction(R.drawable.notification_svgrepo_com, "message", null)
                .addAction(R.drawable.notification_svgrepo_com, "clear", null)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2, notification.build())

        }


        binding.max.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID3)
            notification.setContentTitle(binding.ed1.text.toString())
            notification.setContentText(binding.ed2.text.toString())
            notification.setSmallIcon(android.R.drawable.ic_notification_overlay)
            notification.setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_ERROR)
                .setColor(Color.RED)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .addAction(R.drawable.notification_svgrepo_com, "reply", null)
                .addAction(R.drawable.notification_svgrepo_com, "message", null)
                .addAction(R.drawable.notification_svgrepo_com, "clear", null)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(3, notification.build())

        }


        binding.min.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID4)
            notification.setContentTitle(binding.ed1.text.toString())
            notification.setContentText(binding.ed2.text.toString())
            notification.setSmallIcon(android.R.drawable.stat_notify_voicemail)
            notification.setPriority(NotificationCompat.PRIORITY_MIN)
                .setCategory(NotificationCompat.CATEGORY_CALL)
                .setColor(Color.BLUE)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(4, notification.build())

        }


        binding.low.setOnClickListener {
            val notification = NotificationCompat.Builder(this, App().CHANNEL_ID5)
            notification.setContentTitle(binding.ed1.text.toString())
            notification.setContentText(binding.ed2.text.toString())
            notification.setSmallIcon(android.R.drawable.presence_video_online)
            notification.setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_PROGRESS)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(5, notification.build())

        }
    }
}