package com.iesnervion.cursoandroid_07

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        var n1 = 0
        var n2 = 0

        btnSumar.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = Integer.parseInt(text1.text.toString())
                n2 = Integer.parseInt(text2.text.toString())
            }
            resultado.text = suma(n1, n2).toString()
        }
        btnRestar.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = Integer.parseInt(text1.text.toString())
                n2 = Integer.parseInt(text2.text.toString())
            }
            resultado.text = resta(n1, n2).toString()
        }
        btnDiv.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = Integer.parseInt(text1.text.toString())
                n2 = Integer.parseInt(text2.text.toString())
            }
            if(n2!=0) {
                resultado.text = dividir(n1, n2).toString()
            }else {
                val toast = Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        btnMulti.setOnClickListener{
            if(text1.text.toString().isNotEmpty() && text2.text.toString().isNotEmpty()) {
                n1 = Integer.parseInt(text1.text.toString())
                n2 = Integer.parseInt(text2.text.toString())
            }
            resultado.text = multi(n1, n2).toString()
        }
    }

    fun suma(n1:Int, n2:Int): Int{
        return n1 + n2
    }

    fun resta(n1:Int, n2:Int): Int{
        return n1 - n2
    }

    fun dividir(n1:Int, n2:Int): Int{
        return n1 / n2
    }

    fun multi(n1:Int, n2:Int): Int{
        return n1 * n2
    }

}
