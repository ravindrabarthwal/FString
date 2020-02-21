package com.ravindrabarthwal.fstring_sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ravindrabarthwal.fstring.getFString
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var combinedString = ""
        combinedString += getFString(R.string.test_1) + "\n"
        combinedString += getFString(R.string.test_2) + "\n"
        combinedString += getFString(R.string.test_x, listOf("String", 2))

        hello.text = combinedString
    }

    fun log(message: String) {
        Log.d("Ravindra", message)
    }

}
