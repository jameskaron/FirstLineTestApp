package com.firstlinetestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.Practices.newsFragmentPractise.ui.activities.NewsFragmentMainActivity
import kotlinx.android.synthetic.main.activity_practices_guide.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class PracticesGuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practices_guide)

        btn_to_news_fragment.onClick {
            startActivity<NewsFragmentMainActivity>()
        }

        btn_to_force_offline.onClick {

        }
    }
}
