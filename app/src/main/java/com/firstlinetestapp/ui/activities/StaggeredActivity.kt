package com.firstlinetestapp.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.firstlinetestapp.R
import com.firstlinetestapp.model.Fruit
import com.firstlinetestapp.ui.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_staggered.*
import org.jetbrains.anko.toast
import java.util.*

class StaggeredActivity : AppCompatActivity() {

    private var fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered)

        initFruits()
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        staggered_recycler_view.layoutManager = layoutManager
        staggered_recycler_view.adapter = RecyclerViewAdapter(fruitList){
            toast("clicked ${it.imageId} view")
        }
    }

    private fun initFruits() {
        for (i in 1..20) {
            var fruit = Fruit(i, getRandomLengthName("fruit"))
            fruitList.add(fruit)
            var vegetable = Fruit(i, getRandomLengthName("vegetable"))
            fruitList.add(vegetable)
        }
    }

    private fun getRandomLengthName(name: String): String {
        var length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0..length) {
            builder.append(name)
        }
        return builder.toString()
    }
}
