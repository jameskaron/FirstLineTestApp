package com.firstlinetestapp.chapters.ui.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firstlinetestapp.R
import kotlinx.android.synthetic.main.activity_file_persistence_main.*
import java.io.*

class FilePersistenceMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_persistence_main)


    }

    override fun onDestroy() {
        super.onDestroy()
        var inputText = edit_file_persistence.text.toString()
        save(inputText)
    }

    private fun save(inputText: String) {
        val out = openFileOutput("data", Context.MODE_PRIVATE)
        BufferedWriter(OutputStreamWriter(out)).use {
            it.write(inputText)
        }
    }
}
