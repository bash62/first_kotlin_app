package com.example.td1_formulaire

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<SeekBar>(R.id.sb_age).setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                findViewById<TextView>(R.id.res_age).text = (i.toString())

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

            });


        findViewById<Button>(R.id.btn_valider).setOnClickListener{

            findViewById<TextView>(R.id.res_string).text = (
                    "Bonjour " + findViewById<EditText>(R.id.input_nom).text + " " + findViewById<EditText>(R.id.input_prenom).text
                    + ", vous avez " + (findViewById<SeekBar>(R.id.sb_age).progress).toString() + " ans"
                    )
            Toast.makeText(this, "Bonjour " + findViewById<EditText>(R.id.input_nom)
            .text.toString(), Toast.LENGTH_SHORT).show()
            // Only runs if there is a view that is currently focused
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}