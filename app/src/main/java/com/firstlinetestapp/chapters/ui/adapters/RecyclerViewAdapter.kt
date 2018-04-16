package com.firstlinetestapp.chapters.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.firstlinetestapp.R
import com.firstlinetestapp.chapters.model.Fruit
import kotlinx.android.synthetic.main.fruit_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by James on 31/01/2018.
 */
class RecyclerViewAdapter(private var mFruitList: MutableList<Fruit>, private val viewClick: (Fruit) -> Unit):
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindFruitList(mFruitList[position])
    }

    override fun getItemCount(): Int = mFruitList.size


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerViewAdapter.ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.fruit_item, parent, false)
        val holder = ViewHolder(view, viewClick)
        /*holder.fruitView.onClick {
            var position = holder.adapterPosition
            var fruit = mFruitList[position]
            Toast.makeText(view.context, "clicked ${fruit.imageId} view", Toast.LENGTH_SHORT).show()
        }*/

        holder.itemView.fruit_name.onClick {
            var fruit = mFruitList[holder.adapterPosition]
            Toast.makeText(view.context, "clicked ${fruit.name} view", Toast.LENGTH_SHORT).show()
        }
        return holder
    }

    class ViewHolder(view: View, private val viewClick: (Fruit) -> Unit) : RecyclerView.ViewHolder(view) {

        val fruitView = view

        fun bindFruitList(fruit: Fruit) {
            with(fruit) {
                itemView.fruit_image.text = fruit.imageId.toString()
                itemView.fruit_name.text = fruit.name
                itemView.setOnClickListener { viewClick(this) }
            }
        }

    }
}