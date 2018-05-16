package com.firstlinetestapp.chapters.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.toast

open class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.toast("received in MyBroadcastReceiver")
    }
}
