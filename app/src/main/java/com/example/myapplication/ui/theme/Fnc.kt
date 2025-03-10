package com.example.myapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import java.util.Locale

class Fnc { //Funcions

    @Composable
    fun callImg() {
        Image(
            painter = painterResource(id = R.drawable.flag),
            contentDescription = "Imagen bandera",
            modifier = Modifier.fillMaxWidth().fillMaxSize()
        )
    }

    @Composable
    fun callText() {
        Text(text = stringResource(R.string.language))
        Text(text = stringResource(R.string.hello), modifier = Modifier.padding(top =20.dp))
        Text("${stringResource(R.string.current)} ${integerResource(R.integer.poblacio)}", modifier = Modifier.padding(top = 20.dp))
    }


}
