package com.example.kalkulatoryogrodnicze

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

open class Kalkulator_opryski : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_opryski)

        var button = findViewById<Button>(R.id.button)
        var dawka = findViewById<EditText>(R.id.dawka)
        var objetosc = findViewById<EditText>(R.id.objetosc)
        var ciecz = findViewById<EditText>(R.id.ciecz)
        var iloscsrodka = findViewById<TextView>(R.id.iloscsrodka)
        var wynik = 0.0

        button.setOnClickListener  (
                View.OnClickListener {

                     if (czy_puste(dawka)=="zle" || czy_dobra_wartosc_1_2(dawka)=="zle" || czy_puste(objetosc)=="zle"
                         || czy_dobra_wartosc_5_2(objetosc)=="zle" || czy_puste(ciecz) =="zle" || czy_dobra_wartosc_5_2(ciecz)=="zle") {
                         return@OnClickListener
                     }
                    val view = this.currentFocus
                    if (view != null) {
                        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                        imm.hideSoftInputFromWindow(view.windowToken, 0)
                    }
                    wynik = dawka.text.toString().toDouble() * objetosc.text.toString().toDouble() / ciecz.text.toString().toDouble()
                    iloscsrodka.setText("Ilość środka potrzebnego na zadane dane to: " + String.format("%.0f", wynik ) + " kg/ha")

                }
        )
    }

    fun czy_puste(x:EditText):String {
        var blad=""
        if (TextUtils.isEmpty(x!!.text.toString().trim())) {
            x!!.setError(getString(R.string.puste))
            x!!.requestFocus()
             blad = "zle"
        } else {
             blad = "dobrze"
        }
        return blad
    }

    fun czy_dobra_wartosc_1_2(x:EditText):String {
        var blad=""
        if (!"[0-9]+".toRegex().matches(x!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(x!!.text.toString().trim()))  ) {
            x!!.setError(getString(R.string.liczba))
            x!!.requestFocus()
            blad="zle"
        }
        if (!"[0-9]{1,2}".toRegex().matches(x!!.text.toString().trim() ) && (!"[0-9]{1,2}[.][0-9]{1,2}".toRegex().matches(x!!.text.toString().trim()))  ) {
            x!!.setError(getString(R.string.liczba2))
            x!!.requestFocus()
            blad="zle"
        }
        else {
            blad="dobrze"
        }
        return blad
    }

    fun czy_dobra_wartosc_5_2 (x:EditText):String{
        var blad=""
        if (!"[0-9]+".toRegex().matches(x!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(x!!.text.toString().trim()))  ) {
            x!!.setError(getString(R.string.liczba))
            x!!.requestFocus()
            blad="zle"

        }
        if (!"[0-9]{1,5}".toRegex().matches(x!!.text.toString().trim() ) && (!"[0-9]{1,5}[.][0-9]{1,2}".toRegex().matches(x!!.text.toString().trim()))  ) {
            x!!.setError(getString(R.string.liczba4))
            x!!.requestFocus()
            blad="zle"
        }else{
            blad="dobrze"
        }
        return blad
    }
}