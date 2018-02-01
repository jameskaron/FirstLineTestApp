package com.firstlinetestapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.firstlinetestapp.model.Fruit
import kotlinx.android.synthetic.main.fruit_item.view.*

/**
 * Created by momokohong on 26/01/2018.
 */
class FruitAdapter(context: Context?, textViewResourceId: Int, objects: MutableList<Fruit>?)
    : ArrayAdapter<Fruit>(context, textViewResourceId, objects) {

    companion object {
        var resourceId: Int = 0
    }

    init {
         resourceId = textViewResourceId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val fruit = getItem(position)
//        val view = convertView ?: LayoutInflater.from(context).inflate(resourceId,parent,false)
        var view: View
        var viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            viewHolder = ViewHolder()
            viewHolder.imageId = view.fruit_image
            viewHolder.name = view.fruit_name
            view.tag = viewHolder

        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.imageId.text = fruit.imageId.toString()
        viewHolder.name.text = fruit.name
        return view
    }


    class ViewHolder {
        lateinit var  imageId: TextView
        lateinit var  name: TextView
    }

}