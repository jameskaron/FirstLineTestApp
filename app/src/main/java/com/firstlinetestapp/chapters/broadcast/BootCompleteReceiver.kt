package com.firstlinetestapp.chapters.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.longToast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.longToast("Boot Complete")
    }
}
