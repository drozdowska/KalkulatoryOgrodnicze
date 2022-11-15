package com.example.kalkulatoryogrodnicze

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.math.BigDecimal

class Kalkulator_wysiewu : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_wysiewu)

        var wysiew = findViewById<EditText>(R.id.wysiew)
        var cena = findViewById<EditText>(R.id.cena)
        var masa = findViewById<EditText>(R.id.masa)
        var powierzchnia = findViewById<EditText>(R.id.powierzchnia)
        var kielkowanie2 = findViewById<TextView>(R.id.kielkowanie2)
        var kielkowanie = findViewById<SeekBar>(R.id.kielkowanie)
        var kalkuluj = findViewById<Button>(R.id.kalkuluj)
        var wynik = findViewById<TextView>(R.id.wynik)

        kielkowanie.min = 1
        var x=1
        kielkowanie2.text = x.toString() + "%"

        kielkowanie.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                x=progress
                kielkowanie2.text = x.toString() + "%"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        kalkuluj.setOnClickListener (

            View.OnClickListener {

                if (TextUtils.isEmpty(wysiew!!.text.toString().trim())) {
                    wysiew!!.setError(getString(R.string.puste))
                    wysiew!!.requestFocus()
                    return@OnClickListener
                }
                if (wysiew!!.text.toString().trim().toInt()<=0) {
                    wysiew!!.setError(getString(R.string.zle_wysiew))
                    wysiew!!.requestFocus()
                    return@OnClickListener
                }
                if (TextUtils.isEmpty(masa!!.text.toString().trim())) {
                    masa!!.setError(getString(R.string.puste))
                    masa!!.requestFocus()
                    return@OnClickListener
                }
                if (masa!!.text.toString().trim().toDouble() <=0 ) {
                    masa!!.setError(getString(R.string.zle_wysiew))
                    masa!!.requestFocus()
                    return@OnClickListener
                }
                if (TextUtils.isEmpty(powierzchnia!!.text.toString().trim())) {
                    powierzchnia!!.setError(getString(R.string.puste))
                    powierzchnia!!.requestFocus()
                    return@OnClickListener
                }
                if (powierzchnia!!.text.toString().trim().toDouble() <=0 ) {
                    powierzchnia!!.setError(getString(R.string.zle_wysiew))
                    powierzchnia!!.requestFocus()
                    return@OnClickListener
                }
                if (TextUtils.isEmpty(cena!!.text.toString().trim())) {
                    cena!!.setError(getString(R.string.puste))
                    cena!!.requestFocus()
                    return@OnClickListener
                }

                try {
                    val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                }


                val oplacalnosc: (Int) -> String = { x : Int ->
                    when(x){
                        in 0..55 -> "Bardzo słaba jakość ziaren"
                        in 56..70 -> "Niska jakość ziaren"
                        in 71..85 -> "Średnia jakość ziaren"
                        in 86..95 -> "Dobra jakość ziaren"
                        in 96..100 -> "Najlepsza jakość ziaren"
                        else -> "Brak danych"
                    }
                }
                val view = this.currentFocus
                if (view != null) {
                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                }

                var a: BigDecimal= wysiew!!.text.toString().trim().toBigDecimal()
                var b:BigDecimal=masa!!.text.toString().trim().toBigDecimal()
                var c:BigDecimal = x.toBigDecimal()

                var wartosc: (BigDecimal, BigDecimal, BigDecimal) -> BigDecimal = {
                    a:BigDecimal, b:BigDecimal, c:BigDecimal -> (a*b)/c

                }
                var cena1 = wartosc(a,b,c) * cena!!.text.toString().trim().toBigDecimal()
                var cena2 = cena1!! * powierzchnia!!.text.toString().trim().toBigDecimal()
                wynik.text = wartosc.toString()

                wynik.text = "Potrzeba " + wartosc(a,b,c).setScale(2, BigDecimal.ROUND_HALF_UP).toString() + " kg ziarna na ha.\n" + "Zapłacisz w przybliżeniu: " +  cena1.setScale(2,
                        BigDecimal.ROUND_HALF_UP).toString() +
                        " złotych za nasiona na hektar. \n" + "Za nasiona na pole o powierzchni " + powierzchnia.text.toString().trim() + " ha zapłacisz " +
                        cena2.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + " złotych. \n" +  oplacalnosc(x)

            }
        )
    }
}