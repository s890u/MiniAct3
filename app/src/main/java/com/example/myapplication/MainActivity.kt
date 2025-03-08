package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myApp()
            }
        }
}

@Preview
@Composable
fun myApp() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WellnessScreen()
        }
    }
}

@Composable
fun WellnessScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        StatefulCounter()
    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, label: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = stringResource(R.string.current))
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp).fillMaxWidth(), enabled = count < 10) {
            Text(text = stringResource(R.string.calculate))
        }
    }
}

@Composable
fun StatefulCounter() {
    var waterCount by rememberSaveable { mutableStateOf(0) }
    var juiceCount by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(R.string.language))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.hello))
        }
        StatelessCounter(waterCount, { waterCount++ }, "Water")
    }
}



@Composable
fun PreviewWellnessScreen() {
    MyApplicationTheme {
        WellnessScreen()
    }
}
