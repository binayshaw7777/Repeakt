package com.binayshaw7777.repeakt.util

import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.toImage
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

object Constants {

    val PrimaryColor = Color.argb(0xFF6EDD17)
    val SecondaryColor = Color.argb(0xFF6FEB36)

    val BackgroundColor = linearGradient {
        add(PrimaryColor)
        add(SecondaryColor)
    }.toImage()

    val CardColor = linearGradient {
        add(Color.argb(0xFFEAECF3))
        add(Color.argb(0xFFD0DEE7))
    }.toImage()

    val TextColor = Color.argb(0xFF292929)

    val CardInputLayoutStyle = CssStyle {
        base {
            Modifier
                .fillMaxWidth()
                .background(Background.of(image = CardColor))
                .borderRadius(20.px)
                .padding(20.px)
        }
    }

    val AccessibilityButtonStyle = CssStyle {
        base {
            Modifier
                .margin(10.px)
                .scale(1)
                .color(Colors.Gray)
        }
        Breakpoint.SM {
            Modifier
                .margin(8.px)
                .scale(1)
        }
        Breakpoint.MD {
            Modifier
                .margin(5.px)
                .scale(1.1)
        }
    }
}
