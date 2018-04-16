package com.firstlinetestapp.newsFragmentPractise.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firstlinetestapp.R
import com.firstlinetestapp.newsFragmentPractise.ui.fragments.NewsContentFragment
import kotlinx.android.synthetic.main.activity_news_content.*
import org.jetbrains.anko.startActivity
import java.util.logging.Logger

class NewContentActivity : AppCompatActivity() {

    private val tag = "NewContentActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        Log.d(tag, "Into NewContentActivity")
        var newsTitle = intent.getStringExtra("news_title")
        var newsContent = intent.getStringExtra("news_content")

        val newsContentFragment: NewsContentFragment? = news_content_fragment  as NewsContentFragment?
        newsContentFragment?.refresh(newsTitle, newsContent)

    }

    fun actionStart(newsTitle: String, newsContent: String) {
        startActivity<NewContentActivity>("news_title" to newsTitle, "news_content" to newsContent)

    }
}
