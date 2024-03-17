package com.example.tryit.Notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, intent?.getStringExtra("DATA_SEND"), Toast.LENGTH_SHORT).show()
        Toast.makeText(context, intent?.getStringExtra("DATA_SEND_2"), Toast.LENGTH_SHORT).show()
    }
}