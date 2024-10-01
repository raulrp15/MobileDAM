package com.iesnervion.cursoandroid_07

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var name:EditText
        lateinit var button:Button
    }
    var frente:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<EditText>(R.id.user)
        button = findViewById<Button>(R.id.accept)
        button.setOnClickListener {
            val cambia = Intent(this, Calculator::class.java)
            startActivity(cambia)
        }
    }

    override fun onPause() {
        super.onPause()
        setContentView(R.layout.pausa)
        frente = false
    }

    override fun onResume() {
        super.onResume()
        if(!frente) {
            val toast = Toast.makeText(this, "Bienvenido de nuevo, " + name.text, Toast.LENGTH_SHORT)
            toast.show()
            frente = true

        }
    }

    override fun onStop() {
        super.onStop()
        val noti = Random.nextInt(100)
        val can = "Notificacion"
        val builder = NotificationCompat.Builder(this, can)
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setContentTitle("textTitle")
            .setContentText("textContent")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return@with
            }
            notify(noti, builder.build())
        }
        Log.d(":::Vida", "Put")
    }
}