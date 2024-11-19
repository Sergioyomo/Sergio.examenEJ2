package com.example.sergioexamenej2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorSelectorApp()
        }
    }
}

@Composable
fun ColorSelectorApp() {
    // Estado del color seleccionado
    var selectedColor by remember { mutableStateOf(Color.Gray) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Lista de colores (componente hijo)
        ColorList(
            colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            onColorSelected = { color -> selectedColor = color }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Vista del color seleccionado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(selectedColor)
        )
    }
}


@Composable
fun ColorList(colors: List<Color>, onColorSelected: (Color) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        colors.forEach { color ->
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color)
                    .clickable { onColorSelected(color) }
            )
        }
    }
}
