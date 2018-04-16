package com.firstlinetestapp.chapters.ui.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.firstlinetestapp.R
import kotlinx.android.synthetic.main.title.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick
/**
 * Created by momokohong on 26/01/2018.
 */
class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)

        title_back.onClick {
            val c = getContext() as Activity
            c.finish()
        }

        title_edit.onClick {
            Toast.makeText(getContext(), "Clicked Edit button", Toast.LENGTH_SHORT).show()

        }
    }

}