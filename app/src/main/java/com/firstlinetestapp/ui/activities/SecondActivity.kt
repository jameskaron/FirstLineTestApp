package com.firstlinetestapp.ui.activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.firstlinetestapp.R
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class SecondActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        val data = intent.getStringExtra("extra_data")
//        Log.d("Second",data)

        button2.onClick {
            startActivity<ListViewActivity>()
        }

    }

    companion object {

        fun actionStart(context: Context, data1: String, data2: String) {
            context.startActivity<SecondActivity>("param1" to data1, "param2" to data2)
        }

    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK,intent.putExtra("data_return","Hello FirstActivity"))
        finish()
    }
}
