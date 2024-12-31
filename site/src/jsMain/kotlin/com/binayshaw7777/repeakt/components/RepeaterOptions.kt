package com.binayshaw7777.repeakt.components

import androidx.compose.runtime.Composable
import com.binayshaw7777.repeakt.util.Constants.PrimaryColor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.forms.Checkbox
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import org.jetbrains.compose.web.css.px

@Composable
fun RepeaterOptions(
    title: String,
    checked: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onValueChange(checked.not()) },
        borderColor = PrimaryColor,
        iconColor = PrimaryColor,
        icon = {
            Box(modifier = Modifier.size(8.px).background(PrimaryColor))
        },
        focusOutlineColor = PrimaryColor,
        colorScheme = ColorSchemes.BlueGray
    ) {
        SpanText(title)
    }
}