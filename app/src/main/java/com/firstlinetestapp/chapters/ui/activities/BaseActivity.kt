package com.firstlinetestapp.chapters.ui.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firstlinetestapp.Util.ActivityCollector
import com.practices.forceOfflinePractice.ui.activities.LoginActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.alertDialogLayout
import org.jetbrains.anko.startActivity

/**
 * Created by momokohong on 17/01/2018.
 */
open class BaseActivity : AppCompatActivity() {

    private var receiver = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity",this.javaClass.simpleName)


        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("FORCE_OFFLINE")
        registerReceiver(ForceOfflineReceiver(), intentFilter)
    }

    override fun onPause() {
        super.onPause()
        if (receiver != null) {
            unregisterReceiver(receiver)
            receiver = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)

    }

    class ForceOfflineReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            context?.alert("You are forced to be offline. Please try to login again.") {
                title = "Warning"
                isCancelable = false
                positiveButton("OK" ){
                    ActivityCollector.finishAll()
                    context.startActivity<LoginActivity>()
                }
            }?.show()
        }

    }
}