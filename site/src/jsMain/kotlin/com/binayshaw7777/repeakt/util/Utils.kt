package com.binayshaw7777.repeakt.util

object Utils {
    internal fun repeatText(
        numberOfRepeats: Int = 10,
        text: String,
        addSpace: Boolean = false,
        addNewLine: Boolean = false,
        separator: String = ""
    ): String {
        return buildString {
            repeat(numberOfRepeats) {
                append(text)
                if (addSpace) append(" ")
                if (separator.isNotEmpty()) append(separator)
                if (addNewLine) appendLine()
            }
        }
    }
}