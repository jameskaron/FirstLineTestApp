package com.practices.forceOfflinePractice.ui.activities

import android.os.Bundle
import com.firstlinetestapp.MainActivity
import com.firstlinetestapp.R
import com.firstlinetestapp.chapters.ui.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.onClick {
            var account = account.text.toString()
            var password = password.text.toString()

            if (account == "admin" && password == "123456") {
                startActivity<ForceOfflineMainActivity>()
            }else{
                toast("account or pwd is invalid")
            }

        }
    }
}
