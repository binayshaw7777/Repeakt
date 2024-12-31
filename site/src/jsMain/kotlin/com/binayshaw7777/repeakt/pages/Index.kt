package com.binayshaw7777.repeakt.pages

import androidx.compose.runtime.*
import com.binayshaw7777.repeakt.components.CardInputLayout
import com.binayshaw7777.repeakt.components.InputTextFieldCard
import com.binayshaw7777.repeakt.components.ResultCard
import com.binayshaw7777.repeakt.util.Utils.repeatText
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
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
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
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

        MiddleSection(
            onRepeatChange = { repeats = it },
            onSeparatorChange = { separator = it },
            onButtonClick = {
                result = repeatText(repeats, inputText, addSpace, addNewLine, separator)
            }
        )


        ResultCard(result, onClear = {
            result = ""
        })
    }
}

@Composable
fun MiddleSection(
    modifier: Modifier = Modifier,
    onRepeatChange: (Int) -> Unit,
    onSeparatorChange: (String) -> Unit,
    onButtonClick: () -> Unit
) {

    var separator by remember { mutableStateOf("") }
    var repeats by remember { mutableIntStateOf(10) }
    val scope = rememberCoroutineScope()

    SimpleGrid(
        numColumns = numColumns(base = 1, md = 3),
        modifier = Modifier.margin(topBottom = 2.cssRem).fillMaxWidth(80.vw)
    ) {

        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.margin(top = 10.px, leftRight = 10.px)) {
            SpanText(
                text = "Repeats",
                modifier = Modifier.fontSize(20.px).color(Colors.Black).margin(top = 10.px, leftRight = 10.px)
            )
            CardInputLayout(
                modifier = Modifier.fillMaxWidth().margin(top = 10.px)
            ) {
                Input(
                    type = InputType.Number,
                    value = repeats,
                    onValueChange = {
                        repeats = it?.toInt() ?: 0
                        onRepeatChange(repeats)
                    },
                    modifier = Modifier.fillMaxWidth().attrsModifier {
                        style {
                            property("border", "none")
                            property("outline", "none")
                        }
                    }
                )
            }
        }

        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.margin(top = 10.px, leftRight = 10.px)) {
            SpanText(
                text = "Separator",
                modifier = Modifier.fontSize(20.px).color(Colors.Black).margin(top = 10.px, leftRight = 10.px)
            )
            CardInputLayout(
                modifier = Modifier.fillMaxWidth().margin(top = 10.px)
            ) {
                TextInput(
                    text = separator,
                    onTextChange = {
                        separator = it
                        onSeparatorChange(separator)
                    },
                    modifier = Modifier.fillMaxWidth().attrsModifier {
                        style {
                            property("border", "none")
                            property("outline", "none")
                        }
                    }
                )
            }
        }

        Column(
            modifier = Modifier.margin(leftRight = 10.px, top = 10.px),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                attrs = Modifier.background(Colors.Black).color(Colors.White).borderRadius(20.px)
                    .margin(top = 10.px, leftRight = 10.px)
                    .padding(20.px)
                    .fillMaxWidth()
                    .height(60.percent)
                    .onClick {
                        scope.launch {
                            onButtonClick()
                        }
                    }.toAttrs()

            ) {
                SpanText("Repeakt it", modifier = Modifier.color(Colors.White))
            }
        }
    }
}