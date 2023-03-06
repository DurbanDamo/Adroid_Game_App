package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlay = findViewById<Button>(R.id.btnPlay)

        btnPlay.setOnClickListener {
            callingActivity()
        }
    }
    private fun callingActivity(){
        val txtName = findViewById<EditText>(R.id.txtName)
        val message = txtName.text.toString()

            val intent = Intent(this, GameActivity::class.java).also {
            it.putExtra("userName", message)
            startActivity(it)
        }
        }
    }
