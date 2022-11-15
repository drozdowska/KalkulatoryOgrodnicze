package com.example.kalkulatoryogrodnicze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var start = findViewById<Button>(R.id.start)
        start.setOnClickListener{
            start_menu()
        }
    }

    private fun start_menu() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
    }
}