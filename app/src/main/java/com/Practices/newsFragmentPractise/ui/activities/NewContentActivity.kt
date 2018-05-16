package com.Practices.newsFragmentPractise.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.firstlinetestapp.R
import com.Practices.newsFragmentPractise.ui.fragments.NewsContentFragment
import kotlinx.android.synthetic.main.activity_news_content.*

class NewContentActivity : AppCompatActivity() {

    private val tag = "NewContentActivity"

    companion object {

        fun actionStart(context: Context, newsTitle: String, newsContent: String) {
            val intent = Intent(context, NewContentActivity::class.java)
            intent.putExtra("news_title", newsTitle)
            intent.putExtra("news_content", newsContent)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        Log.d(tag, "Into NewContentActivity")
        var newsTitle = intent.getStringExtra("news_title")
        var newsContent = intent.getStringExtra("news_content")

        val newsContentFragment: NewsContentFragment? = activity_news_content_fragment  as NewsContentFragment?
        newsContentFragment?.refresh(newsTitle, newsContent)

    }


}
