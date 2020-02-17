package com.example.ejemplo_transicion_animada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.core.app.ActivityOptionsCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.get
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_image.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items = ArrayList<Imagen>()
        items.add(Imagen(R.drawable.image1))
        items.add(Imagen(R.drawable.image2))
        items.add(Imagen(R.drawable.image3))
        items.add(Imagen(R.drawable.image4))
        items.add(Imagen(R.drawable.image5))
        items.add(Imagen(R.drawable.image6))
        items.add(Imagen(R.drawable.image7))
        items.add(Imagen(R.drawable.image8))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = ImagesAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,true)
        /*recView.setLayoutManager(StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL))*/



        recView.itemAnimator = DefaultItemAnimator()

        /*val imagen = findViewById(R.id.idimagen) as ImageView*/
        /*imagen.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                imageSwitcher.setImageDrawable(imagen.getDrawable())
            }
        })
*/
        adaptador.onClick = {
            val intent = Intent(this, MainActivity2::class.java)
            val item = items.get(recView.getChildAdapterPosition(it))

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
            options?.putInt("LOGO", item.imagen)

            //Añadimos la información al Intent
            intent.putExtras(options!!)
            startActivity(intent, options)
        }

    }

}
