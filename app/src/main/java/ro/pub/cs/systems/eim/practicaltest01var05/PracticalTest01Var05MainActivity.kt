package ro.pub.cs.systems.eim.practicaltest01var05

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var05MainActivity : AppCompatActivity() {

    private lateinit var textInput: TextView
    private lateinit var clicks: TextView
    var noClicks = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var05_main)

        textInput = findViewById(R.id.textView)
        clicks = findViewById(R.id.textView2)

        val topLeftButton = findViewById<Button>(R.id.top_left)
        topLeftButton.setOnClickListener {
            var previous_text = textInput.text.toString()
            textInput.setText(previous_text + "Top left ")
            noClicks++
            clicks.setText(noClicks.toString())
        }

        val topRightButton = findViewById<Button>(R.id.top_right)
        topRightButton.setOnClickListener {
            var previous_text = textInput.text.toString()
            textInput.setText(previous_text + "Top right ")
            noClicks++
            clicks.setText(noClicks.toString())
        }

        val bottomLeftButton = findViewById<Button>(R.id.bottom_left)
        bottomLeftButton.setOnClickListener {
            var previous_text = textInput.text.toString()
            textInput.setText(previous_text + "bottom left ")
            noClicks++
            clicks.setText(noClicks.toString())
        }

        val bottomRightButton = findViewById<Button>(R.id.button5)
        bottomRightButton.setOnClickListener {
            var previous_text = textInput.text.toString()
            textInput.setText(previous_text + "bottom right ")
            noClicks++
            clicks.setText(noClicks.toString())
        }

        val centerButton = findViewById<Button>(R.id.button6)
        centerButton.setOnClickListener {
            var previous_text = textInput.text.toString()
            textInput.setText(previous_text + "center ")
            noClicks++
            clicks.setText(noClicks.toString())
        }


        val activityResultsLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    // verificam daca am primit un mesaj de la activitate secundara cu rezultatul operatiilor
                        Toast.makeText(
                            this,
                            "The activity returned with result OK with result ",
                            Toast.LENGTH_LONG
                        ).show()
                }
            }

        val navigateToSecondaryActivityButton =
            findViewById<Button>(R.id.second_Activity)
        //cand dau click pe buton
        navigateToSecondaryActivityButton.setOnClickListener {
            //creez intent la secondaryactivity
            val intent = Intent(this, PracticalTest01Var05SecondaryActivity::class.java)
            // asta pune numerele in activitatea urmatoare
            intent.putExtra("textView", textInput.text.toString())
            //pornesc intent
            activityResultsLauncher.launch(intent)
        }

    }

        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            // Salvăm textul curent din textInput
            outState.putString("textInputValue", textInput.text.toString())
            // Salvăm numărul total de click-uri
            outState.putInt("noClicksValue", noClicks)
        }
    }
