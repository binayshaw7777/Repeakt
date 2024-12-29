package com.binayshaw7777.repeakt.components

import androidx.compose.runtime.*
import com.binayshaw7777.repeakt.util.Constants.AccessibilityButtonStyle
import com.binayshaw7777.repeakt.util.Constants.CardColor
import com.binayshaw7777.repeakt.util.Constants.TextColor
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaCheck
import com.varabyte.kobweb.silk.components.icons.fa.FaCopy
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Br

// TODO: Clear + Download text + Share text option
@Composable
fun ResultCard(result: String) {
    var showCopedPasswordToolTip by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(showCopedPasswordToolTip) {
        window.setTimeout({
            showCopedPasswordToolTip = false
        }, 2000)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(80.percent)
            .heightIn(min = 50.px)
            .borderRadius(20.px)
            .margin(bottom = 50.px)
            .background(Background.of(image = CardColor)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.px, alignment = Alignment.CenterVertically)
    ) {
        Column(
            modifier = Modifier
                .width(100.percent - 40.px)
                .margin(top = 10.px, leftRight = 10.px)
                .styleModifier {
                    property("word-wrap", "break-word")
                    property("white-space", "initial")
                },
            verticalArrangement = Arrangement.spacedBy(4.px),
            horizontalAlignment = Alignment.Start
        ) {
            result.split("\n").forEach { line ->
                if (line.isNotEmpty()) {
                    SpanText(text = line, modifier = Modifier.fillMaxWidth().color(TextColor).styleModifier {
                        property("word-wrap", "break-word")
                    })
                } else Br()
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth().padding(leftRight = 20.px, bottom = 20.px),
            contentAlignment = Alignment.CenterEnd
        ) {
            if (showCopedPasswordToolTip) {
                FaCheck(modifier = AccessibilityButtonStyle.toModifier())
            } else {
                FaCopy(modifier = AccessibilityButtonStyle.toModifier().then(Modifier.onClick {
                    window.navigator.clipboard.writeText(result)
                    showCopedPasswordToolTip = true
                }))
            }
        }
    }
}