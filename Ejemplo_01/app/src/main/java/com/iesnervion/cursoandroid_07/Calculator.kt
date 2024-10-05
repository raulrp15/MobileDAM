package com.iesnervion.cursoandroid_07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {

    lateinit var text1:EditText
    lateinit var text2:EditText
    lateinit var btnSumar:Button
    lateinit var btnRestar:Button
    lateinit var btnDiv:Button
    lateinit var btnMulti:Button
    lateinit var resultado:TextView
    lateinit var volver:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)



        text1 = findViewById(R.id.pmrNum)
        text2 = findViewById(R.id.sdoNum)
        btnSumar = findViewById(R.id.suma)
        btnRestar = findViewById(R.id.resta)
        btnDiv = findViewById(R.id.division)
        btnMulti = findViewById(R.id.multi)
        resultado = findViewById(R.id.res)
        volver = findViewById(R.id.volver)

        var n1 = 0.0
        var n2 = 0.0

        btnSumar.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = text1.text.toString().toDouble()
                n2 = text2.text.toString().toDouble()
            }
            resultado.text = suma(n1, n2).toString()
        }
        btnRestar.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = text1.text.toString().toDouble()
                n2 = text2.text.toString().toDouble()
            }
            resultado.text = resta(n1, n2).toString()
        }
        btnDiv.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = text1.text.toString().toDouble()
                n2 = text2.text.toString().toDouble()
            }
            if(n2!=0.0) {
                resultado.text = dividir(n1, n2).toString()
            }else {
                val toast = Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        btnMulti.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = text1.text.toString().toDouble()
                n2 = text2.text.toString().toDouble()
            }
            resultado.text = multi(n1, n2).toString()
        }

        volver.setOnClickListener{
            val cambia = Intent(this, MainActivity::class.java)
            startActivity(cambia)
        }
    }

    fun suma(n1:Double, n2:Double): Double{
        return n1 + n2
    }

    fun resta(n1: Double, n2: Double): Double {
        return n1 - n2
    }

    fun dividir(n1:Double, n2:Double): Double{
        return n1 / n2
    }

    fun multi(n1:Double, n2:Double): Double{
        return n1 * n2
    }

}
