package com.firstlinetestapp.chapters.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstlinetestapp.R

/**
 * Created by James on 01/02/2018.
 */
class AnotherRightFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.another_right_fragment,container,false)
    }
}