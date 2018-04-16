package com.firstlinetestapp.newsFragmentPractise.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.firstlinetestapp.R
import com.firstlinetestapp.chapters.model.News
import com.firstlinetestapp.newsFragmentPractise.ui.activities.NewContentActivity
import kotlinx.android.synthetic.main.activity_news_content.*
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.news_title_frag.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by James on 30/03/2018.
 */
class NewsTitleFragment : Fragment() {

    companion object {
        private const val TAG = "NewsTitleFragment"
        private var isTwoPane: Boolean = false
        var twoPaneFragment : NewsContentFragment? = null
    }

    init {
        println("Into $TAG")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        isTwoPane = news_content_layout != null
        isTwoPane = activity.findViewById<FrameLayout>(R.id.news_content_layout) != null
        if (isTwoPane){
            twoPaneFragment = news_content_fragment as NewsContentFragment?
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        news_title_recycler_view.layoutManager = LinearLayoutManager(activity)
        news_title_recycler_view.adapter = NewsAdapter(getNews())
    }

    class NewsAdapter(private var newsList: MutableList<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        init {
            println("$TAG Into NewsAdapter")
        }
        override fun getItemCount(): Int = newsList.size

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bindNews(newsList[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsAdapter.ViewHolder {
            Log.d(TAG, "Into NewsAdapter onCreateViewHolder")

            val view = LayoutInflater.from(parent?.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            view.onClick {
                var news = newsList[holder.adapterPosition]
                if (isTwoPane) {
//                    val newsContentFragment: NewsContentFragment = fragmentManager.findFragmentById(R.id.news_content_fragment) as NewsContentFragment
                    println("isTwoPane true")
                    val newsContentFragment = twoPaneFragment
                    newsContentFragment?.refresh(news.title, news.content)
                } else {
                    println("isTwoPane false")
                    NewContentActivity().actionStart(news.title, news.content)
                }
            }

            return holder
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsView = view

            fun bindNews(news: News) {
                with(news) {
                    itemView.news_title.text = news.title
                }
            }
        }
    }

    private fun getNews(): MutableList<News>{
        val newsList = mutableListOf<News>()
        for (i in 1..50){
            var news = News()
            news.title = "This is news title $i"
            news.content = "This is news content $i."
            newsList.add(news)
        }
        return newsList
    }

}