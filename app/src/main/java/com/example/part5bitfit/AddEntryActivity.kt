package com.example.part5bitfit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class AddEntryActivity : AppCompatActivity() {
    private val viewModel: WaterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_entry)

        val glassesInput: EditText = findViewById(R.id.glassesInput)
        val saveButton: Button = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val glasses = glassesInput.text.toString().toIntOrNull() ?: 0
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val entry = WaterEntry(date = date, glasses = glasses)
            viewModel.insert(entry)
            finish()
        }
    }
}
