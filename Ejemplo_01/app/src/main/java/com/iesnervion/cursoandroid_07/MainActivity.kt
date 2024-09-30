package com.iesnervion.cursoandroid_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(":::Vida", "He creado el create")
        val uName:String =
    }

    override fun onStart() {
        super.onStart()
        Log.d(":::Vida", "He creado el start")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(":::Vida", "He creado el reinicio")
    }

    override fun onResume() {
        super.onResume()
        Log.d(":::Vida", "He creado el resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(":::Vida", "He creado el pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(":::Vida", "He creado el stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(":::Vida", "He creado el destroy")
    }
}