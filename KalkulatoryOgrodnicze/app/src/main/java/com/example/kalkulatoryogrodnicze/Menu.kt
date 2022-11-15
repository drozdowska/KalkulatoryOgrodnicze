package com.example.kalkulatoryogrodnicze

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var wysiew = findViewById<Button>(R.id.wysiew)
        wysiew.setOnClickListener {
            start_wysiew()
        }
        var wiezby = findViewById<Button>(R.id.wiezby)
        wiezby.setOnClickListener {
            start_wiezby()
        }
        var opryski = findViewById<Button>(R.id.opryski)
        opryski.setOnClickListener {
            start_opryski()
        }
    }
    private fun start_wysiew() {
        val intent = Intent(this, Kalkulator_wysiewu::class.java)
        startActivity(intent)
    }
    private fun start_wiezby() {
        val intent = Intent(this, Kalkulator_wiezby::class.java)
        startActivity(intent)
    }
    private fun start_opryski() {
        val intent = Intent(this, Kalkulator_opryski::class.java)
        startActivity(intent)
    }
}