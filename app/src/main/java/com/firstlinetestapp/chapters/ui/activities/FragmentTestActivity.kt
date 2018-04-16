package com.firstlinetestapp.chapters.ui.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.firstlinetestapp.R
import com.firstlinetestapp.R.id.left_fragment_btn
import com.firstlinetestapp.chapters.ui.fragments.AnotherRightFragment
import com.firstlinetestapp.chapters.ui.fragments.RightFragment

class FragmentTestActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)

//        left_fragment_btn.setOnClickListener(this)
//        replaceFragment(RightFragment())

    }

    /*override fun onClick(v: View?) {
        when (v?.id) {
            R.id.left_fragment_btn -> replaceFragment(AnotherRightFragment())
        }
    }*/

   /* private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.right_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }*/
}
