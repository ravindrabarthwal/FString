package com.ravindrabarthwal.fstring_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravindrabarthwal.fstring.getFString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var combinedString = ""
        combinedString += getFString(R.string.test_1) + "\n"
        combinedString += getFString(R.string.test_2) + "\n"

        hello.text = combinedString
    }
}
