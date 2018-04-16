package com.firstlinetestapp.chapters.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.firstlinetestapp.R
import com.firstlinetestapp.newsFragmentPractise.ui.activities.NewContentActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity


class MainActivity : BaseActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        var tempData = savedInstanceState?.getString("data_key")
        if (tempData != null) Log.d(TAG, tempData)

        to_second_btn.onClick {
            //            val intent = Intent("com.firstline.ACTION_START")
//            intent.addCategory("com.firstline.MY_CATEGORY")
//            intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("http://www.baidu.com")
//            val data = "Hello SecondActivity"
//            startActivity<SecondActivity>("extra_data" to data)

//            startActivityForResult<SecondActivity>(1)

            SecondActivity.actionStart(this@MainActivity, "data1", "data2")
        }

        to_recycle_view_btn.onClick {
            startActivity<RecycleViewActivity>()
        }

        staggered_btn.onClick {
            startActivity<StaggeredActivity>()
        }

        to_fragment.onClick {
            startActivity<FragmentTestActivity>()
        }

        fragment_practice.onClick {
            startActivity<NewContentActivity>()
        }


    }

    fun initView() {
        supportActionBar?.hide()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d(TAG, returnedData)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.add_item -> longToast("You clicked Add")
            R.id.remove_item -> longToast("You clicked Remove")

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString("data_key", "onSaveInstanceState data")

    }
}
