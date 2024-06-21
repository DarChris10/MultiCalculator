package org.multicalculator.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
<<<<<<< HEAD
=======
import androidx.compose.runtime.saveable.rememberSaveable
>>>>>>> fbee656 (variables adding)
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
<<<<<<< HEAD
import androidx.compose.ui.tooling.preview.Preview
=======
>>>>>>> fbee656 (variables adding)

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
<<<<<<< HEAD
    val operation = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .padding(16.dp)
    ) {
=======

    var leftNumber by rememberSaveable { mutableStateOf(0) }
    var rightNumber by rememberSaveable { mutableStateOf(0) }
    var operation by rememberSaveable { mutableStateOf("") }
    var complete by rememberSaveable { mutableStateOf(false) }


>>>>>>> fbee656 (variables adding)
        CalcDisplay(display = displayText)

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Column {
                for (i in 7 downTo 1 step 3) {
<<<<<<< HEAD
                    CalcRow(display = displayText, startNum = i, numButtons = 3)
                }
                Row {
                    CalcNumericButton(number = 0, display = displayText)
                    CalcEqualsButton(display = displayText, operation = operation)
=======
                    CalcRow(onPress = { numberPress(it) }, startNum = i, numButtons = 3)
                }
                Row {
                    CalcNumericButton(number = 0, onPress = { numberPress(it) })
                    CalcEqualsButton(onPress = { equalsPress() }, operation = operation)
>>>>>>> fbee656 (variables adding)
                }
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                val operations = listOf("+", "-", "*", "/")
                operations.forEach { operation ->
<<<<<<< HEAD
                    CalcOperationButton(operation = operation, display = displayText)
=======
                    CalcOperationButton(operation = operation, onPress = { operationPress(it) })
>>>>>>> fbee656 (variables adding)
                }
            }
        }
    }
<<<<<<< HEAD
}

@Composable
fun CalcRow(display: MutableState<String>, startNum: Int, numButtons: Int) {
    val endNum = startNum + numButtons
    Row(modifier = Modifier.padding(0.dp)) {
        for (num in startNum until endNum) {
            CalcNumericButton(number = num, display = display)
        }
    }
}

=======

}
@Composable
fun CalcRow(onPress: (number: Int) -> Unit, startNum: Int, numButtons: Int) {
    val endNum = startNum + numButtons
    Row(modifier = Modifier.padding(0.dp)) {
        for (num in startNum until endNum) {
            CalcNumericButton(number = num, onPress = onPress)
        }
    }
}
>>>>>>> fbee656 (variables adding)
@Composable
fun CalcDisplay(display: MutableState<String>) {
    Text(
        text = display.value,
        fontSize = 32.sp,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(5.dp)
    )
}
<<<<<<< HEAD

@Composable
fun CalcNumericButton(number: Int, display: MutableState<String>) {
    Button(
        onClick = { display.value = if (display.value == "0") number.toString() else display.value + number.toString() },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = number.toString())
    }
}

@Composable
fun CalcOperationButton(operation: String, display: MutableState<String>) {
    Button(
        onClick = { display.value += operation },
=======
@Composable
fun CalcNumericButton(number: Int, onPress: (number: Int) -> Unit) {
    Button(
        onClick = { onPress(number)  },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = number.toString())

    }
}
@Composable
fun CalcOperationButton(operation: String, onPress: (operation: String) -> Unit) {
    Button(
        onClick = { onPress(operation) },
>>>>>>> fbee656 (variables adding)
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = operation)
    }
}
<<<<<<< HEAD

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
        },
        modifier = Modifier.padding(4.dp)
    ) {
        Text(text = "=")
    }
}
=======
@Composable
fun CalcEqualsButton(onPress: ()-> Unit, operation: String) {
    Button(
        onClick = { onPress() },
        modifier = Modifier.padding(4.dp)

    ) {
        Text(text = "=")
    }
}
>>>>>>> fbee656 (variables adding)
