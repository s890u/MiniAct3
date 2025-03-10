package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Fnc
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                myApp()

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
    fun StatelessCounter(onIncrement: () -> Unit, modifier: Modifier = Modifier, result: String?) {
        Column(modifier = modifier.padding(top = 16.dp)) {
            result?.let {
                Text("${stringResource(R.string.expected)} $result", modifier = Modifier.padding(bottom = 20.dp, top = 10.dp))
            }
        }
    }

    @Composable
    fun StatefulCounter() {
        val configuration = LocalConfiguration.current
        val isLandscape = configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE

        val integer = integerResource(R.integer.poblacio)
        var poblac by rememberSaveable { mutableStateOf(integer) }
        var populationPrediction by rememberSaveable { mutableStateOf<String?>(null) }
        var multiplicador by rememberSaveable { mutableStateOf<String?>(null) }
        var currentYear by rememberSaveable { mutableStateOf(2025) }

        fun calculatePrediction() {
            val local = Locale.getDefault().language
            val creixement = when (local){
                "en" -> 1.5
                "es" -> 1.1
                else -> 1.0
            }

            currentYear += 1
            val predictedPopulation = (poblac * creixement * (currentYear - 2025).toDouble()).toLong()
            populationPrediction = "$currentYear: $predictedPopulation"
        }

        val local = Locale.getDefault().language
        multiplicador = when (local){
            "en" -> 1.5.toString()
            "es" -> 1.1.toString()
            else -> 1.0.toString()
        }


        if (!isLandscape){
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Fnc().callText()
                StatelessCounter({ poblac++ },result = populationPrediction)
                Button(
                    onClick = { calculatePrediction() },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.calculate))
                }
                multiplicador?.let{
                    Text("M: $multiplicador", modifier = Modifier.padding(bottom = 20.dp, top = 10.dp))
                }
                Fnc().callImg()


            }
        }else{
            Row(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Fnc().callText()
                    StatelessCounter({ poblac++ },result = populationPrediction)
                    Button(onClick = { calculatePrediction() }) {
                        Text(text = stringResource(R.string.calculate))
                    }
                }
                multiplicador?.let{
                    Text("M: $multiplicador", modifier = Modifier.padding(bottom = 20.dp, top = 10.dp))
                }
                Fnc().callImg()
            }
        }
    }
}


