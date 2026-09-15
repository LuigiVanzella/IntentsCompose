package br.edu.ifsp.scl.sc3033953.intentscompose.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddWordScreen(
    currentValue: String,
    modifier: Modifier = Modifier,
    onConcatenateClick: (String) -> Unit
){
    var newWord by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = currentValue,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "String no estado atual") },
            modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp)
        )

        OutlinedTextField(
            value = newWord,
            onValueChange = {event -> newWord = event},
            label = {Text(text = "Nova Palavra")},
            modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp)
        )

        Button(
            onClick = {if(newWord.isNotEmpty()) onConcatenateClick(newWord)},
            modifier = Modifier.fillMaxWidth().padding(0.dp, 16.dp)
        ) {
            Text(text = "Concatenar")
        }
    }
}

@Preview(showBackground = true, name = "Add Word Screen Preview")
@Composable
fun AddWordScreenPreview() {
    AddWordScreen(
        currentValue = "Teste",
        onConcatenateClick = {}
    )
}