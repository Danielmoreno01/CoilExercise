package com.example.coil

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import okio.ByteString.Companion.encode


import androidx.compose.material3.*

import coil.compose.AsyncImage

@Composable
fun Screen1(navController: NavController) {
    val nombre = remember { mutableStateOf(TextFieldValue("")) }
    val raza = remember { mutableStateOf(TextFieldValue("")) }
    val tamano = remember { mutableStateOf(TextFieldValue("")) }
    val edad = remember { mutableStateOf(TextFieldValue("")) }
    val fotoUrl = remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("IDENTIFICACION MASCOTAS", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nombre.value, onValueChange = { nombre.value = it }, label = { Text("Nombre") })
        OutlinedTextField(value = raza.value, onValueChange = { raza.value = it }, label = { Text("Raza") })
        OutlinedTextField(value = tamano.value, onValueChange = { tamano.value = it }, label = { Text("Tamaño") })
        OutlinedTextField(value = edad.value, onValueChange = { edad.value = it }, label = { Text("Edad") })
        OutlinedTextField(value = fotoUrl.value, onValueChange = { fotoUrl.value = it }, label = { Text("Foto URL") })

        Spacer(modifier = Modifier.height(16.dp))

        AsyncImage(
            model = fotoUrl.value.text,
            contentDescription = "Imagen de la mascota",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (
                    nombre.value.text.isNotEmpty() &&
                    raza.value.text.isNotEmpty() &&
                    tamano.value.text.isNotEmpty() &&
                    edad.value.text.isNotEmpty() &&
                    fotoUrl.value.text.isNotEmpty()
                ) {
                    val ruta =
                        "screen2/${nombre.value.text.encode()}/${raza.value.text.encode()}/${tamano.value.text.encode()}/${edad.value.text.encode()}/${fotoUrl.value.text.encode()}"
                    navController.navigate(ruta)
                } else {
                    Toast.makeText(context, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Registrar")
        }
    }
}

// Helper para encode de strings en URLs
fun String.encode(): String = java.net.URLEncoder.encode(this, "UTF-8")
