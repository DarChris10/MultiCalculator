package org.multicalculator.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcView()
        }
    }
}

@Composable
fun CalcView() {
    val displayText = remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CalcDisplay(display = displayText)
        CalcNumericButton(number = 0, display = displayText)
    }
}

@Composable
fun CalcDisplay(display: MutableState<String>) {
    Text(
        text = display.value,
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    )
}

@Composable
fun CalcNumericButton(number: Int, display: MutableState<String>) {
    Button(
        onClick = { display.value = if (display.value == "0") number.toString() else display.value + number.toString() }
    ) {
        Text(text = number.toString())
    }
}
