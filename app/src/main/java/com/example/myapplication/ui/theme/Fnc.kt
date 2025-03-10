package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

class Fnc { //Funcions

    @Composable
    fun CallImg() {
        Image(
            painter = painterResource(id = R.drawable.flag),
            contentDescription = "Imagen bandera",
            modifier = Modifier.fillMaxWidth().fillMaxSize()
                .padding(100.dp)
        )
    }

    @Composable
    fun CallText() {
        Text(text = stringResource(R.string.language))
        Text(text = stringResource(R.string.hello), modifier = Modifier.padding(top =20.dp))
        Text("${stringResource(R.string.current)} ${integerResource(R.integer.poblacio)}", modifier = Modifier.padding(top = 20.dp))
    }
}
