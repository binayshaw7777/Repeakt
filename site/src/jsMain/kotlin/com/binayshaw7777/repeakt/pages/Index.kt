package com.binayshaw7777.repeakt.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.Input
import com.varabyte.kobweb.silk.components.forms.TextInput
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        var text by remember { mutableStateOf("") }
        var repeats by remember { mutableIntStateOf(1) }
        var result by remember { mutableStateOf("") }

        Column {
            TextInput(
                text = text,
                onTextChange = { text = it }
            )
            Input(
                type = InputType.Number,
                value = repeats,
                onValueChange = { repeats = it?.toInt() ?: 1 }
            )
            Button(
                onClick = {
                    val answer = StringBuilder()
                    repeat(repeats) {
                        answer.append(text)
                    }
                    result = answer.toString()
                }
            ) {
                Text("Repeat $repeats times")
            }
            Text(result)
        }
    }
}
