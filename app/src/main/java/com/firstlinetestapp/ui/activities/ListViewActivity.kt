package com.firstlinetestapp.ui.activities

import android.os.Bundle
import com.firstlinetestapp.R
import com.firstlinetestapp.Util.ActivityCollector
import com.firstlinetestapp.model.Fruit
import com.firstlinetestapp.ui.adapters.FruitAdapter
import kotlinx.android.synthetic.main.activity_third.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onItemClick
import org.jetbrains.anko.toast

class ListViewActivity : BaseActivity() {

    private var fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        initFruits()
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        list_view.adapter = adapter
        list_view.onItemClick { parent, view, position, id ->  toast(fruitList[position].name)}

    }

    override fun onBackPressed() {
        ActivityCollector.finishAll()
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    private fun initFruits(){
        for (i in 1..2) {
            var fruit = Fruit(i,"fruit:$i")
            fruitList.add(fruit)
            var vegetable = Fruit(i,"vegetable:$i")
            fruitList.add(vegetable)
        }


    }
}
