package com.example.imadpart1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var inputAgeEditText: EditText
private lateinit var matchButton: Button
private lateinit var clearButton: Button
private lateinit var resultTextView: TextView

private val historicalFigures = listOf(
    "Nelson Mandela" to 95,
    "William Shakespeare" to 52,
    // Add more historical figures and their ages here
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputAgeEditText = findViewById(R.id.inputAgeEditText)
        matchButton = findViewById(R.id.matchButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)

        matchButton.setOnClickListener {
            matchAge()
        }

        clearButton.setOnClickListener {
            clearInput()
        }
    }


    private fun matchAge() {
        val inputAgeStr = inputAgeEditText.text.toString()
        if (inputAgeStr.isEmpty()) {
            resultTextView.text = "Please enter your age"
            return
        }

        val inputAge = inputAgeStr.toIntOrNull()
        if (inputAge == null) {
            resultTextView.text = "Invalid age format. Please enter a whole number."
            return
        }

        if (inputAge !in 20..100) {
            resultTextView.text = "The age must be between 20 and 100."
            return
        }

        val matchedFigure = historicalFigures.find { it.second == inputAge }
        if (matchedFigure != null) {
            resultTextView.text = "Your age matches with ${matchedFigure.first}"
        } else {
            resultTextView.text = "No historical figure found for your age."
        }
    }

    private fun clearInput() {
        inputAgeEditText.text.clear()
        resultTextView.text = ""
    }
}
