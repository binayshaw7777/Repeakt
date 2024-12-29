package com.binayshaw7777.repeakt.pages

import androidx.compose.runtime.*
import com.binayshaw7777.repeakt.components.CardInputLayout
import com.binayshaw7777.repeakt.components.InputTextFieldCard
import com.binayshaw7777.repeakt.components.ResultCard
import com.binayshaw7777.repeakt.util.Utils.repeatText
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Input
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button

@Page
@Composable
fun HomePage() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        RepeaktScreen()
    }
}

@Composable
fun RepeaktScreen() {

    var result by remember { mutableStateOf("") }
    var inputText by remember { mutableStateOf("") }
    var separator by remember { mutableStateOf("") }
    var repeats by remember { mutableIntStateOf(10) }
    var addSpace by remember { mutableStateOf(false) }
    var addNewLine by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                Background.of(
                    image = linearGradient(angle = (-45).deg) {
                        add(Color.argb(0xFF6EDD17))
                        add(Color.argb(0xFF6FEB36))
                    }.toImage()
                )
            ),
        verticalArrangement = Arrangement.spacedBy(60.px, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            text = "Repeakt",
            modifier = Modifier.color(Colors.White).fillMaxWidth().fontSize(50.px).textAlign(TextAlign.Center)
        )

        InputTextFieldCard(
            onTextChange = { inputText = it },
            onAddSpaceValueChange = { addSpace = it },
            onAddNewLineValueChange = { addNewLine = it }
        )

        Row(
            modifier = Modifier.fillMaxWidth(80.percent),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.px)
        ) {

            CardInputLayout {
                Input(
                    type = InputType.Number,
                    value = repeats,
                    onValueChange = { repeats = it?.toInt() ?: 0 },
                    modifier = Modifier.fillMaxWidth().attrsModifier {
                        style {
                            property("border", "none")
                            property("outline", "none")
                        }
                    }
                )
            }

            CardInputLayout {
                TextInput(
                    text = separator,
                    onTextChange = { separator = it },
                    modifier = Modifier.fillMaxWidth().attrsModifier {
                        style {
                            property("border", "none")
                            property("outline", "none")
                        }
                    }
                )
            }

            Button(
                attrs = Modifier.fillMaxWidth().background(Colors.Black).color(Colors.White).borderRadius(20.px)
                    .padding(20.px)
                    .onClick {
                        scope.launch {
                            result = repeatText(repeats, inputText, addSpace, addNewLine, separator)
                        }
                    }.toAttrs()

            ) {
                SpanText("Repeakt it", modifier = Modifier.color(Colors.White))
            }
        }

        ResultCard(result)
    }
}
