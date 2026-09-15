package br.edu.ifsp.scl.sc3033953.intentscompose.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    newWord: String,
    modifier: Modifier = Modifier,
    onAddWordClick: (String) -> Unit = {}
){
    var currentString by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(newWord) {
        if (newWord.isNotEmpty()) {
            currentString = if (currentString.isEmpty()) newWord else "$currentString $newWord"
        }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = currentString,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "String Atual") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {onAddWordClick(currentString)},
            modifier = Modifier.fillMaxWidth().padding(0.dp, 16.dp)
        ) {
            Text(text = "Adicionar palavra")
        }
        Button(
            onClick = { currentString = "" },
            modifier = Modifier.fillMaxWidth().padding(0.dp, 16.dp)
        ) {
            Text(text = "Reiniciar")
        }
    }
}

@Preview(showBackground = true, name = "Home Screen Preview")
@Composable
fun HomeScreenPreview() {
    HomeScreen(newWord = "")
}