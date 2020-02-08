package com.ravindrabarthwal.fstring_sample

import android.app.Application
import com.ravindrabarthwal.fstring.FString

import com.ravindrabarthwal.fstring_sample.R.string as RString // Import this

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FString.init(RString::class.java) // Initializes the FString

        val jsonString = """
            {
                "test_2": "updated dynamically",
                "test_1": "I'll be removed below",
            }
        """.trimIndent()

        FString.update(this, jsonString) // Updates the string

        val jsonStringToClear = """
            [
                "test_1"
            ]
        """.trimIndent()

        FString.clear(this, jsonStringToClear) // Clear the string "test_1"
    }
}