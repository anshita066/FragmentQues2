package com.example.fragmentques2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        // Get views reference
        val fragDemoBtn = findViewById<Button>(R.id.fragmentDemoBtn)

        // attach on click listeners
        fragDemoBtn.setOnClickListener {
            // send user to next activity
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}