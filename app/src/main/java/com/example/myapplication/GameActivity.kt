package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class GameActivity : AppCompatActivity() {

    // Declare an array of strings
    internal var Superhero = arrayOf(
        "Batman", "Superman", "Ironman", "Spiderman", "Antman", "Powerman", "Latexman", "Musicman"
    )
    // Declare all other variables
    lateinit var superhero: String
    lateinit var random: Random

    // Declare variables for the view
    lateinit var txtQuestionContainer: TextView
    lateinit var etUserInput: EditText
    lateinit var btnCheck: Button
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val message = "Hello " + intent.getStringExtra("userName") + " guess the word"
        val textMessage = findViewById<TextView>(R.id.txtUName).apply {
            text = message
        }

        txtQuestionContainer = findViewById(R.id.txtQuestionContainer)

        etUserInput = findViewById(R.id.etUserInput)

        btnCheck = findViewById(R.id.btnCheck)
        btnNext = findViewById(R.id.btnNext)

        // intilize the random variable
        random = Random()

        // Actual logic
        superhero = Superhero[random.nextInt(Superhero.size)]
        txtQuestionContainer.text = mixWords(superhero)

        // Set the Listener to the Check button
        btnCheck.setOnClickListener{
            if(etUserInput.text.toString().equals(superhero, ignoreCase = true))
            {
                Toast.makeText(this@GameActivity,"You got it right!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this@GameActivity,"You got it wrong!", Toast.LENGTH_SHORT).show()
        }

        // Set the Listener to the Next button
        btnNext.setOnClickListener{
            superhero = Superhero[random.nextInt(Superhero.size)]
            txtQuestionContainer.text = mixWords(superhero)
        }

    }
        fun mixWords(word: String) : String
        {
            val word = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile({it.isEmpty()}).toTypedArray())

            Collections.shuffle(word)
            var mixed = ""

            for (i in word)
            {
             mixed += i
            }
            return mixed
        }
    }
