package com.firstlinetestapp

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.firstlinetestapp.chapters.broadcast.MyBroadcastReceiver
import com.firstlinetestapp.chapters.ui.activities.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : BaseActivity() {

    private val TAG: String = "MainActivity"

    private lateinit var networkChangeReceiver: NetworkChangeReceiver
    private lateinit var networkIntentFilter: IntentFilter

    lateinit var localReceiver: LocalReceiver
    lateinit var localBroadcastIntentFilter: IntentFilter
    lateinit var localBroadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()

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

        btn_broadcast.onClick {
            sendOrderedBroadcast(Intent(this@MainActivity, MyBroadcastReceiver::class.java)
                    .setAction("MY_BROADCAST"), null)

            /*val it = Intent()
            it.action = "MY_BROADCAST"
//            it.component = ComponentName("com.m.broadcast","com.m.broadcast.AnotherBroadCastReceiver")
            it.component = ComponentName("com.firstlinetestapp.chapters.broadcast"
                    ,"com.firstlinetestapp.chapters.broadcast.MyBroadcastReceiver")
            sendBroadcast(it)*/
        }

        btn_local_broadcast.onClick {
            localBroadcastManager.sendBroadcast(Intent("LOCAL_BROADCAST"))
        }

        btn_practices.onClick {
            startActivity<PracticesGuideActivity>()
        }

        btn_file_persistence.onClick {
            startActivity<FilePersistenceMainActivity>()
        }

    }

    private fun initView() {
        supportActionBar?.hide()
    }

    private fun initData() {
        networkIntentFilter = IntentFilter()
        networkIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        networkChangeReceiver = NetworkChangeReceiver()
        registerReceiver(networkChangeReceiver, networkIntentFilter)

        localBroadcastIntentFilter = IntentFilter()
        localBroadcastIntentFilter.addAction("LOCAL_BROADCAST")
        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        localReceiver = LocalReceiver()
        localBroadcastManager.registerReceiver(localReceiver, localBroadcastIntentFilter)



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

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(networkChangeReceiver)

        localBroadcastManager.unregisterReceiver(localReceiver)
    }

    class NetworkChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val connectionManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectionManager.activeNetworkInfo
            if (networkInfo != null && networkInfo.isAvailable) {
                context.longToast("network is available")
            }else{
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show()
            }
        }

    }

    class LocalReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            context?.toast("received local broadcast")

        }

    }


}
