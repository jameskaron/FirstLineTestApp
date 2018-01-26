package com.firstlinetestapp.ui.activities

import android.os.Bundle
import com.firstlinetestapp.R
import com.firstlinetestapp.Util.ActivityCollector

class ThirdActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    override fun onBackPressed() {
        ActivityCollector.finishAll()
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}
