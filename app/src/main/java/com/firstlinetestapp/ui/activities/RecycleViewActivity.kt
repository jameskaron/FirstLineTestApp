package com.firstlinetestapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.firstlinetestapp.R
import com.firstlinetestapp.R.id.recycler_view
import com.firstlinetestapp.model.Fruit
import com.firstlinetestapp.ui.adapters.FruitRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    private var fruitList = mutableListOf<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        initFruits()
        val layoutManager = LinearLayoutManager(this)
        //horizontal layout to add:
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_view.layoutManager = layoutManager

        recycler_view.adapter = FruitRecyclerViewAdapter(fruitList)
    }

    private fun initFruits() {
        for (i in 1..5) {
            var fruit = Fruit(i, "fruit:$i")
            fruitList.add(fruit)
            var vegetable = Fruit(i, "vegetable:$i")
            fruitList.add(vegetable)
        }
    }
}
