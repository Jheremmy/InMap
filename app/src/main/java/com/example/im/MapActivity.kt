package com.example.im

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.app.AlertDialog
import android.graphics.Matrix
import android.graphics.PointF

class MapActivity : AppCompatActivity() {

    private val markedPlaces = mutableListOf<String>() // Lista para almacenar lugares marcados
    private lateinit var mapImageView: ImageView
    private var scaleFactor = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapImageView = findViewById(R.id.map_image_view)
        val addMarkerButton: Button = findViewById(R.id.add_marker_button)
        val savedPlacesButton: Button = findViewById(R.id.saved_places_button)
        val zoomInButton: Button = findViewById(R.id.zoom_in_button)
        val zoomOutButton: Button = findViewById(R.id.zoom_out_button)

        addMarkerButton.setOnClickListener {
            showAddMarkerDialog()
        }

        savedPlacesButton.setOnClickListener {
            navigateToSavedPlaces()
        }

        zoomInButton.setOnClickListener {
            zoomMap(1.2f) // Aumentar el zoom
        }

        zoomOutButton.setOnClickListener {
            zoomMap(0.8f) // Disminuir el zoom
        }

        // Cargar la imagen del mapa
        mapImageView.setImageResource(R.drawable.map) // Asegúrate de que el archivo de la imagen esté en res/drawable
    }

    private fun showAddMarkerDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_add_marker, null)
        val markerNameInput: EditText = view.findViewById(R.id.marker_name_input)

        builder.setView(view)
            .setTitle("Agregar Marcador")
            .setPositiveButton("Agregar") { _, _ ->
                val newMarker = markerNameInput.text.toString()
                if (newMarker.isNotEmpty()) {
                    markedPlaces.add(newMarker)
                    Toast.makeText(this, "$newMarker agregado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "El nombre del marcador no puede estar vacío", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun navigateToSavedPlaces() {
        val intent = Intent(this, SavedPlacesActivity::class.java)
        intent.putStringArrayListExtra("marked_places", ArrayList(markedPlaces))
        startActivity(intent)
    }

    private fun zoomMap(factor: Float) {
        scaleFactor *= factor
        val matrix = Matrix()
        matrix.setScale(scaleFactor, scaleFactor, mapImageView.width / 2f, mapImageView.height / 2f)
        mapImageView.imageMatrix = matrix
    }
}