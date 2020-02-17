package com.example.ejemplo_transicion_animada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolMensaje = findViewById(R.id.toolc) as androidx.appcompat.widget.Toolbar
        val imagLogo = findViewById<ImageView>(R.id.photo)

        val bundle = intent.extras

        toolMensaje.title= bundle!!.getString("NOM")

        imagLogo.setImageResource(bundle!!.getInt("LOGO"))
    }

}
