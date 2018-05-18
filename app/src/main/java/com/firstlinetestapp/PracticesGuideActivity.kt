package com.firstlinetestapp

import android.os.Bundle
import com.practices.newsFragmentPractise.ui.activities.NewsFragmentMainActivity
import com.firstlinetestapp.chapters.ui.activities.BaseActivity
import com.practices.forceOfflinePractice.ui.activities.LoginActivity
import kotlinx.android.synthetic.main.activity_practices_guide.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class PracticesGuideActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practices_guide)

        btn_to_news_fragment.onClick {
            startActivity<NewsFragmentMainActivity>()
        }

        btn_to_force_offline.onClick {
            startActivity<LoginActivity>()
        }
    }
}
