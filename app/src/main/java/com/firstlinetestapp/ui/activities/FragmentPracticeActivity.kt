package com.firstlinetestapp.ui.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.firstlinetestapp.R
import com.firstlinetestapp.ui.fragments.NewContentFragment
import kotlinx.android.synthetic.main.activity_frament_practice.*
import org.jetbrains.anko.startActivity

class FragmentPracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frament_practice)

        var newsTitle = intent.getStringExtra("news_title")
        var newsContent = intent.getStringExtra("news_content")

        val newsContentFragment: NewContentFragment = news_content_fragment as NewContentFragment
        newsContentFragment.refresh(newsTitle, newsContent)

    }

    fun actionStart(context: Context, newsTitle: String, newsContent: String) {
        startActivity<FragmentPracticeActivity>("news_title" to newsTitle, "news_content" to newsContent)

    }
}
