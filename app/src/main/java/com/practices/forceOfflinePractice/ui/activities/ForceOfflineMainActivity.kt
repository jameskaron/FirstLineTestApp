package com.practices.forceOfflinePractice.ui.activities

import android.content.Intent
import android.os.Bundle
import com.firstlinetestapp.R
import com.firstlinetestapp.chapters.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_force_offline_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class ForceOfflineMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_force_offline_main)

        force_offline.onClick {
            sendBroadcast(Intent().setAction("FORCE_OFFLINE"))
        }
    }
}
