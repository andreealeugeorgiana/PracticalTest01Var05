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

class PracticalTest01Var05SecondaryActivity : AppCompatActivity() {

    private lateinit var textInput: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test_01_var05_secondary)

        textInput = findViewById(R.id.textView)

        val v1 = intent.getStringExtra("textView")

        textInput.text = v1

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("textView", textInput.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

        val button1 = findViewById<Button>(R.id.button6)
        button1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("", textInput.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }


    }

}
