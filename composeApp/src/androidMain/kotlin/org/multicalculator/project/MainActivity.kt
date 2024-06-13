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
    val operation = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CalcDisplay(display = displayText)
        Row {
            CalcNumericButton(number = 0, display = displayText)
            CalcEqualsButton(display = displayText, operation = operation)
        }
    }
}

@Composable
fun CalcEqualsButton(display: MutableState<String>, operation: MutableState<String>) {
    Button(
        onClick = {
            val parts = display.value.split(operation.value)
            if (parts.size == 2) {
                val result = when (operation.value) {
                    "+" -> parts[0].toDouble() + parts[1].toDouble()
                    "-" -> parts[0].toDouble() - parts[1].toDouble()
                    "*" -> parts[0].toDouble() * parts[1].toDouble()
                    "/" -> parts[0].toDouble() / parts[1].toDouble()
                    else -> 0.0
                }
                display.value = result.toString()
                operation.value = ""
            }
        }
    ) {
        Text(text = "=")
    }
}
