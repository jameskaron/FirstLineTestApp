package com.firstlinetestapp.chapters.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firstlinetestapp.Util.ActivityCollector

/**
 * Created by momokohong on 17/01/2018.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity",this.javaClass.simpleName)


        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)

    }
}