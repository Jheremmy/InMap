package com.example.im

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.im.com.example.im.MarkerDetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewMap: ImageView
    private val markers: MutableList<Marker> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewMap = findViewById(R.id.imageViewMap)

        val buttonAddMarker: Button = findViewById(R.id.buttonAddMarker)
        buttonAddMarker.setOnClickListener {
            // Agregar un marcador
            addMarker("Lugar Ejemplo", "Descripción del lugar.")
        }

        val buttonViewMarkers: Button = findViewById(R.id.buttonViewMarkers)
        buttonViewMarkers.setOnClickListener {
            // Ver marcadores guardados
            viewMarkers()
        }
    }

    private fun addMarker(name: String, description: String) {
        val newMarker = Marker(name, description)
        markers.add(newMarker)
        Toast.makeText(this, "Marcador agregado: $name", Toast.LENGTH_SHORT).show()
    }

    private fun viewMarkers() {
        if (markers.isEmpty()) {
            Toast.makeText(this, "No hay marcadores guardados.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, MarkerDetailsActivity::class.java)
            intent.putParcelableArrayListExtra("markers", ArrayList(markers))
            startActivity(intent)
        }
    }
}