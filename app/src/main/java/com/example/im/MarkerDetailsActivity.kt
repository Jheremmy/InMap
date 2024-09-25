package com.example.im

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MarkerDetailsActivity : AppCompatActivity() {
    private lateinit var textViewPlaceName: TextView
    private lateinit var textViewDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker_details)

        textViewPlaceName = findViewById(R.id.textViewPlaceName)
        textViewDescription = findViewById(R.id.textViewDescription)

        val markers: List<Marker>? = intent.getParcelableArrayListExtra("markers")

        if (markers != null && markers.isNotEmpty()) {
            val marker = markers[0] // Muestra solo el primer marcador como ejemplo
            textViewPlaceName.text = marker.name
            textViewDescription.text = marker.description
        }

        val buttonDeleteMarker: Button = findViewById(R.id.buttonDeleteMarker)
        buttonDeleteMarker.setOnClickListener {
            // Lógica para eliminar el marcador (si lo deseas)
            finish()
        }
    }
}