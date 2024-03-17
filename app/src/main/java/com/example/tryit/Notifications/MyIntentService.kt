package com.example.tryit.Notifications

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        if(intent!=null){
            intent.getStringExtra("data_send")?.let { Log.d("MYTAG", it) }
        }
    }

    private fun handleActionFoo(param1: String?, param2: String?) {

    }

    private fun handleActionBaz(param1: String?, param2: String?) {

    }

    companion object {
    }
}