package com.example.coil

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

@Composable
fun Screen2(nombre: String, raza: String, tamano: String, edad: String, foto: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Información de la Mascota", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Nombre: $nombre")
        Text("Raza: $raza")
        Text("Tamaño: $tamano")
        Text("Edad: $edad")

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar la imagen usando Coil con manejo de errores
        if (foto.isNotEmpty()) {
            AsyncImage(
                model = foto,
                contentDescription = "Foto de la mascota",
                modifier = Modifier.size(200.dp),

            )
        } else {
            Text("No se ha proporcionado una URL válida para la imagen.")
        }
    }
}
