package com.example.eventoboton

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.Toolbar
import com.example.eventoboton.modelo.Planeta

class SegundaActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_actividad2)

        var toolbar = findViewById<Toolbar>(R.id.toolbar_id)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        onLoadItemsInMenu(toolbar)

        var textoResultado = findViewById<TextView>(R.id.txtResult)
        var nombrePlaneta = findViewById<TextView>(R.id.txtNombrePlaneta)
        val rescatado: String? = intent.getStringExtra("valor").orEmpty()
        val planetaRescatado = intent.getParcelableExtra<Planeta>("planeta")

        if (rescatado != null && planetaRescatado != null) {
            textoResultado.text = rescatado
            nombrePlaneta.text  = planetaRescatado.nombre

        } else {
            textoResultado.text = "No llego aca"

        }

    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu,menu)
        if (menu is MenuBuilder){
            menu.setOptionalIconsVisible(true)
        }
        return true

    }

    fun onLoadItemsInMenu(toolbar: Toolbar){

        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                 R.id.action_search -> {
                     // Hacer la buesqueda
                      true
                 }
                R.id.action_share -> {
                    // Compartir algo
                    true
                }
                else -> false
            }

        }

    }
}