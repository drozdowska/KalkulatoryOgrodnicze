package com.example.kalkulatoryogrodnicze

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlin.math.roundToInt

class Kalkulator_wiezby : AppCompatActivity() {

    var list_of_item = arrayOf("Więźba prostokątna", "Więźba trójkątna", "Więźba kwadratowa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_wiezby)

        var text: String=""
        var kwadratowa = findViewById<LinearLayout>(R.id.kwadratowa)
        var prostokatna = findViewById<LinearLayout>(R.id.prostokatna)
        var trojkatna = findViewById<LinearLayout>(R.id.trojkatna)
        var spinner = findViewById<Spinner>(R.id.spinner)
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,list_of_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        var liczbasadzonek = 0.0
        spinner!!.setAdapter(adapter)
        var rezultat = findViewById<TextView>(R.id.rezultat)
        var oblicz= findViewById<Button>(R.id.oblicz)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                (parent!!.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                spinner.setSelection(position)
                text = parent?.getItemAtPosition(position).toString()

                if (text=="Więźba kwadratowa") {
                    kwadratowa.visibility = View.VISIBLE
                    trojkatna.visibility = View.GONE
                    prostokatna.visibility = View.GONE

                    oblicz.setOnClickListener (
                        View.OnClickListener {


                            var Kbok = findViewById<EditText>(R.id.Kbok)
                            var Kodstep = findViewById<EditText>(R.id.Kodstep)

                            if (TextUtils.isEmpty(Kodstep!!.text.toString().trim())) {
                                Kodstep!!.setError(getString(R.string.puste))
                                Kodstep!!.requestFocus()
                                return@OnClickListener
                            }
                            if (!"[0-9]+".toRegex().matches(Kodstep!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Kodstep!!.text.toString().trim()))  ) {
                                Kodstep!!.setError(getString(R.string.liczba))
                                Kodstep!!.requestFocus()
                                return@OnClickListener
                            }
                            if (!"[0-9]{1,2}".toRegex().matches(Kodstep!!.text.toString().trim() ) && (!"[0-9]{1,2}[.][0-9]{1,2}".toRegex().matches(Kodstep!!.text.toString().trim()))  ) {
                                Kodstep!!.setError(getString(R.string.liczba2))
                                Kodstep!!.requestFocus()
                                return@OnClickListener
                            }
                            if (TextUtils.isEmpty(Kbok!!.text.toString().trim())) {
                                Kbok!!.setError(getString(R.string.puste))
                                Kbok!!.requestFocus()
                                return@OnClickListener
                            }
                            if (!"[0-9]+".toRegex().matches(Kbok!!.text.toString().trim()) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Kbok!!.text.toString().trim()) ) ) {
                                Kbok!!.setError(getString(R.string.liczba))
                                Kbok!!.requestFocus()
                                return@OnClickListener
                            }
                            if (!"[0-9]{1,9}".toRegex().matches(Kbok!!.text.toString().trim()) && (!"[0-9]{1,9}[.][0-9]{1,2}".toRegex().matches(Kbok!!.text.toString().trim()) ) ) {
                                Kbok!!.setError(getString(R.string.liczba))
                                Kbok!!.requestFocus()
                                return@OnClickListener
                            }
                            liczbasadzonek = (Kbok.text.toString().toDouble() * Kbok.text.toString()
                                    .toDouble()) / (Kodstep.text.toString()
                                    .toDouble() * Kodstep.text.toString().toDouble())
                            rezultat.setText("Liczba sadzonek potrzebna na zadany obszar to: " + String.format("%.0f",liczbasadzonek))

                            if (view != null) {
                                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow(view.windowToken, 0)
                            }
                        }
                    )
                }

                if (text=="Więźba prostokątna") {
                    prostokatna.visibility = View.VISIBLE
                    kwadratowa.visibility = View.GONE
                    trojkatna.visibility = View.GONE

                    oblicz.setOnClickListener (
                            View.OnClickListener {
                                var Pboka = findViewById<EditText>(R.id.Pboka)
                                var Pbokb = findViewById<EditText>(R.id.Pbokb)
                                var Podstep = findViewById<EditText>(R.id.Podstep)
                                var Przedy = findViewById<EditText>(R.id.Przedy)

                                if (TextUtils.isEmpty(Pboka!!.text.toString().trim())) {
                                    Pboka!!.setError(getString(R.string.puste))
                                    Pboka!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(Pboka!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Pboka!!.text.toString().trim()))  ) {
                                    Pboka!!.setError(getString(R.string.liczba))
                                    Pboka!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,9}".toRegex().matches(Pboka!!.text.toString().trim() ) && (!"[0-9]{1,9}[.][0-9]{1,9}".toRegex().matches(Pboka!!.text.toString().trim()))  ) {
                                    Pboka!!.setError(getString(R.string.liczba3))
                                    Pboka!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (TextUtils.isEmpty(Pbokb!!.text.toString().trim())) {
                                    Pbokb!!.setError(getString(R.string.puste))
                                    Pbokb!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(Pbokb!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Pbokb!!.text.toString().trim()))  ) {
                                    Pbokb!!.setError(getString(R.string.liczba))
                                    Pbokb!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,9}".toRegex().matches(Pbokb!!.text.toString().trim() ) && (!"[0-9]{1,9}[.][0-9]{1,9}".toRegex().matches(Pbokb!!.text.toString().trim()))  ) {
                                    Pbokb!!.setError(getString(R.string.liczba3))
                                    Pbokb!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (TextUtils.isEmpty(Podstep!!.text.toString().trim())) {
                                    Podstep!!.setError(getString(R.string.puste))
                                    Podstep!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(Podstep!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Podstep!!.text.toString().trim()))  ) {
                                    Podstep!!.setError(getString(R.string.liczba))
                                    Podstep!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,2}".toRegex().matches(Podstep!!.text.toString().trim() ) && (!"[0-9]{1,2}[.][0-9]{1,2}".toRegex().matches(Podstep!!.text.toString().trim()))  ) {
                                    Podstep!!.setError(getString(R.string.liczba2))
                                    Podstep!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (TextUtils.isEmpty(Przedy!!.text.toString().trim())) {
                                    Przedy!!.setError(getString(R.string.puste))
                                    Przedy!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(Przedy!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Przedy!!.text.toString().trim()))  ) {
                                    Przedy!!.setError(getString(R.string.liczba))
                                    Przedy!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,2}".toRegex().matches(Przedy!!.text.toString().trim() ) && (!"[0-9]{1,2}[.][0-9]{1,2}".toRegex().matches(Przedy!!.text.toString().trim()))  ) {
                                    Przedy!!.setError(getString(R.string.liczba2))
                                    Przedy!!.requestFocus()
                                    return@OnClickListener
                                }
                                liczbasadzonek = (Pboka.text.toString().toDouble() * Pbokb.text.toString().toDouble()) / (Podstep.text.toString().toDouble() * Przedy.text.toString().toDouble())
                                rezultat.setText("Liczba sadzonek potrzebna na zadany obszar to: " + String.format("%.0f",liczbasadzonek))

                                if (view != null) {
                                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                                }
                            }
                    )
                }
                if (text=="Więźba trójkątna") {
                    trojkatna.visibility = View.VISIBLE
                    prostokatna.visibility = View.GONE
                    kwadratowa.visibility = View.GONE

                    oblicz.setOnClickListener (
                            View.OnClickListener {
                                var Todstep = findViewById<EditText>(R.id.Todstep)
                                var podstawa = findViewById<EditText>(R.id.podstawa)
                                var wysokosc = findViewById<EditText>(R.id.wysokosc)

                                if (TextUtils.isEmpty(podstawa!!.text.toString().trim())) {
                                    podstawa!!.setError(getString(R.string.puste))
                                    podstawa!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(podstawa!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(podstawa!!.text.toString().trim()))  ) {
                                    podstawa!!.setError(getString(R.string.liczba))
                                    podstawa!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,9}".toRegex().matches(podstawa!!.text.toString().trim() ) && (!"[0-9]{1,9}[.][0-9]{1,9}".toRegex().matches(podstawa!!.text.toString().trim()))  ) {
                                    podstawa!!.setError(getString(R.string.liczba3))
                                    podstawa!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (TextUtils.isEmpty(wysokosc!!.text.toString().trim())) {
                                    wysokosc!!.setError(getString(R.string.puste))
                                    wysokosc!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(wysokosc!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(wysokosc!!.text.toString().trim()))  ) {
                                    wysokosc!!.setError(getString(R.string.liczba))
                                    wysokosc!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,9}".toRegex().matches(wysokosc!!.text.toString().trim() ) && (!"[0-9]{1,9}[.][0-9]{1,9}".toRegex().matches(wysokosc!!.text.toString().trim()))  ) {
                                    wysokosc!!.setError(getString(R.string.liczba3))
                                    wysokosc!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (TextUtils.isEmpty(Todstep!!.text.toString().trim())) {
                                    Todstep!!.setError(getString(R.string.puste))
                                    Todstep!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]+".toRegex().matches(Todstep!!.text.toString().trim() ) && (!"[0-9]+[.]+[0-9]+".toRegex().matches(Todstep!!.text.toString().trim()))  ) {
                                    Todstep!!.setError(getString(R.string.liczba))
                                    Todstep!!.requestFocus()
                                    return@OnClickListener
                                }
                                if (!"[0-9]{1,2}".toRegex().matches(Todstep!!.text.toString().trim() ) && (!"[0-9]{1,2}[.][0-9]{1,2}".toRegex().matches(Todstep!!.text.toString().trim()))  ) {
                                    Todstep!!.setError(getString(R.string.liczba2))
                                    Todstep!!.requestFocus()
                                    return@OnClickListener
                                }

                                if (view != null) {
                                    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                                    imm.hideSoftInputFromWindow(view.windowToken, 0)
                                }

                                liczbasadzonek = ((podstawa.text.toString().toDouble() * wysokosc.text.toString().toDouble()) / 2.0) / (Todstep.text.toString().toDouble() * 1.15)
                                rezultat.setText("Liczba sadzonek potrzebna na zadany obszar to: " + String.format("%.0f", liczbasadzonek))
                            }
                    )
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                (parent!!.getChildAt(0) as TextView).setTextColor(Color.WHITE)
            }
        }
    }
}