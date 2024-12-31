package com.binayshaw7777.repeakt.components

import androidx.compose.runtime.Composable
import com.binayshaw7777.repeakt.util.Constants.CardInputLayoutStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.style.toModifier

@Composable
fun CardInputLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .then(CardInputLayoutStyle.toModifier())
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}