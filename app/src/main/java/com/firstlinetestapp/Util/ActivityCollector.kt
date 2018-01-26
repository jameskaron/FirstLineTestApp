package com.firstlinetestapp.Util

import android.app.Activity

/**
 * Created by momokohong on 18/01/2018.
 */
object ActivityCollector {

     private var activities : MutableList<Activity>? = mutableListOf()

    fun addActivity(activity: Activity) {
         activities?.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities?.remove(activity)
    }

    fun finishAll() {
        activities?.filterNot { it.isFinishing }?.forEach { it.finish() }
    }
}