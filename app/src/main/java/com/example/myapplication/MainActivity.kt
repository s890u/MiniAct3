package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
    Image(
        painter = painterResource(id = R.drawable.flag),
        contentDescription = "Imagen bandera",
        modifier = Modifier.fillMaxWidth().height(150.dp).padding(top = 30.dp)
    )
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier, result: String?) {
    Column(modifier = modifier.padding(16.dp)) {
        Text("${stringResource(R.string.current)} $count")
        result?.let {
            Text("${stringResource(R.string.expected)} $result", modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
fun StatefulCounter() {
    val integer = integerResource(R.integer.poblacio)
    var waterCount by rememberSaveable { mutableStateOf(integer) }
    var populationPrediction by rememberSaveable { mutableStateOf<String?>(null) }
    var currentYear by rememberSaveable { mutableStateOf(2025) }

    fun calculatePrediction() {
        val creixement = 1.02 // +2%
        currentYear += 1
        val predictedPopulation = (waterCount * Math.pow(creixement, (currentYear - 2025).toDouble())).toLong()
        populationPrediction = "$currentYear: $predictedPopulation"
    }

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
        StatelessCounter(waterCount, { waterCount++ },result = populationPrediction)
        Button(
            onClick = { calculatePrediction() },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.calculate))
        }
    }
}




