package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import java.util.Locale

class Landscape() {
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
        Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            StatefulCounter()
            Image(
                painter = painterResource(id = R.drawable.flag),
                contentDescription = "Imagen bandera",
                modifier = Modifier.height(150.dp).padding(0.dp)
            )
        }
    }

    @Composable
    fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier, result: String?) {
        Column(modifier = modifier.padding(top = 30.dp)) {
            Text("${stringResource(R.string.current)} $count")
            result?.let {
                Text("${stringResource(R.string.expected)} $result", modifier = Modifier.padding(top = 30.dp))
            }
        }
    }

    @Composable
    fun StatefulCounter() {
        MainActivity().StatefulCounter()
}}
