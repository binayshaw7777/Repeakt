package com.binayshaw7777.repeakt.components

import androidx.compose.runtime.*
import com.binayshaw7777.repeakt.util.Constants.AccessibilityButtonStyle
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.css.Resize
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.icons.fa.FaTrashCan
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.TextArea

@Composable
fun InputTextFieldCard(
    onTextChange: (String) -> Unit = {},
    onAddSpaceValueChange: (Boolean) -> Unit = {},
    onAddNewLineValueChange: (Boolean) -> Unit = {}
) {

    var inputText by remember { mutableStateOf("") }
    var wordsSize by remember { mutableIntStateOf(0) }
    var charactersSize by remember { mutableIntStateOf(0) }

    var addSpace by remember { mutableStateOf(false) }
    var addNewLine by remember { mutableStateOf(false) }

    LaunchedEffect(inputText) {
        wordsSize = if (inputText.isEmpty()) 0 else inputText.split("\\s+".toRegex()).size
        charactersSize = inputText.length
    }

    Column(
        modifier = Modifier.fillMaxWidth(80.percent)
            .borderRadius(40.px)
            .background(
                Background.of(
                    image = linearGradient {
                        add(Color.argb(0xFFEAECF3))
                        add(Color.argb(0xFFD0DEE7))
                    }.toImage()
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.px, alignment = Alignment.CenterVertically)
    ) {
        TextArea(
            attrs = Modifier.background(Colors.Transparent).boxSizing(BoxSizing.BorderBox).width(100.percent - 40.px)
                .heightIn(min = 20.vh, max = 40.vh)
                .margin(top = 40.px)
                .resize(Resize.Vertical)
                .color(Color.argb(0xFF292929)).attrsModifier {
                    style {
                        property("border", "none")
                        property("outline", "none")
                    }
                }.toAttrs {
                    onInput {
                        inputText = it.value
                        onTextChange(inputText)
                    }
                }, value = inputText
        )
        SpanText(
            "Words: $wordsSize Characters: $charactersSize",
            modifier = Modifier.color(Colors.Gray)
                .width(32.vw - 24.px)
                .fontSize(16.px)
                .margin(leftRight = 20.px)
                .textAlign(TextAlign.End)
                .align(Alignment.End)
        )

        Div(
            attrs = Modifier
                .width(32.vw - 24.px)
                .height(0.px)
                .border(1.px, LineStyle.Solid, Colors.Black.copy(alpha = 10))
                .display(DisplayStyle.InlineBlock)
                .align(Alignment.End)
                .margin(leftRight =20.px)
                .toAttrs()
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.px, leftRight = 20.px),
            horizontalArrangement = Arrangement.spacedBy(20.px, alignment = Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RepeaterOptions(
                title = "Add Space",
                checked = addSpace,
                onValueChange = {
                    console.log(
                        "New value coming on check is: $it where val" +
                                "ue for current is: $addSpace"
                    )
                    addSpace = it
                    onAddSpaceValueChange(it)
                }
            )

            RepeaterOptions(
                title = "Add New Line",
                checked = addNewLine,
                onValueChange = {
                    console.log("New value coming on check is: $it where value for current is: $addNewLine")
                    addNewLine = it
                    onAddNewLineValueChange(it)
                }
            )
            FaTrashCan(
                modifier = AccessibilityButtonStyle.toModifier().color(Colors.Red).onClick {
                    inputText = ""
                    onTextChange("")
                }
            )
        }
    }
}