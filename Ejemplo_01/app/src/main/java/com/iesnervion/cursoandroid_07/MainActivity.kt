package com.iesnervion.cursoandroid_07

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var name:EditText
        lateinit var button:Button
    }

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
        var toast = Toast.makeText(this, "Bienvenido de nuevo, " + name.text, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onStop() {
        super.onStop()
        val noti = Random.nextInt(100)
        val can = "Notificacion"
        var builder = NotificationCompat.Builder(this, can)
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