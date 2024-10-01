package com.iesnervion.cursoandroid_07

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintSet.Constraint

@SuppressLint("StaticFieldLeak")
lateinit var name:EditText
@SuppressLint("StaticFieldLeak")
lateinit var button:Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(":::Vida", "He creado el create")
        name = findViewById<EditText>(R.id.user)
        button = findViewById<Button>(R.id.accept)
        button.setOnClickListener {
            setContentView(R.layout.bienvenida)
        }
    }



    override fun onPause() {
        super.onPause()
        setContentView(R.layout.pausa)
    }
    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
    }
}