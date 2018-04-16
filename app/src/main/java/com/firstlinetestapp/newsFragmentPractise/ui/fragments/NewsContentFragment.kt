package com.firstlinetestapp.newsFragmentPractise.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstlinetestapp.R
import kotlinx.android.synthetic.main.news_content_frag.*

/**
 * Created by James on 02/02/2018.
 */
class NewsContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.news_content_frag, container, false)
    }

    //refresh news
     fun refresh(newsTitle: String, newsContent: String) {
        visibility_layout.visibility = View.VISIBLE
        news_title.text = newsTitle
        news_content.text = newsContent
    }
}