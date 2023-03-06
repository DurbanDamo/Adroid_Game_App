package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val message = "Hello " + intent.getStringExtra("userName") + " guess the word"
        val textMessage = findViewById<TextView>(R.id.txtUName).apply {
            text = message
        }
    }
}