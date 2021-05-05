package org.kryptonmc.krypton.util.csv

import java.io.StringWriter

/**
 * All of the credit for the content of this file has to go to the Apache
 * team. This is basically a Kotlin port of their CSV escaper.
 */

private const val CSV_DELIMETER = ','
private const val CSV_QUOTE = '"'
private const val CSV_QUOTE_STRING = CSV_QUOTE.toString()
private val CSV_SEARCH_CHARACTERS = charArrayOf(CSV_DELIMETER, CSV_QUOTE, '\r', '\n')

val Any?.escapedString: String
    get() = this?.toString()?.escapeCSV() ?: "[null]"

fun String.escapeCSV(): String {
    val writer = StringWriter(length * 2)
    translate(writer)
    return writer.toString()
}

fun String.translate(writer: StringWriter) {
    var position = 0
    while (position < length) {
        val consumed = translate(position, writer)
        if (consumed == 0) {
            val c1 = get(position)
            writer.write(c1.code)
            position++
            if (c1.isHighSurrogate() && position < length) {
                val c2 = get(position)
                if (c2.isHighSurrogate()) {
                    writer.write(c2.code)
                    position++
                }
            }
            continue
        }
        repeat(consumed) { position += codePointAt(position).charCount() }
    }
}

fun String.translate(index: Int, writer: StringWriter): Int {
    require(index == 0) { "CSV escaper should never reach the [1] index!" }
    if (CSV_SEARCH_CHARACTERS !in this) {
        writer.write(this)
    } else {
        writer.write(CSV_QUOTE.code)
        writer.write(replace(CSV_QUOTE_STRING, CSV_QUOTE_STRING + CSV_QUOTE_STRING))
        writer.write(CSV_QUOTE.code)
    }
    return codePointCount(0, length)
}

private operator fun String.contains(characters: CharArray): Boolean {
    for (i in indices) {
        val char = this[i]
        for (j in characters.indices) {
            if (characters[j] != char) continue
            if (char.isHighSurrogate()) {
                if (j == characters.lastIndex) return false
                if (i >= lastIndex || characters[j + 1] != this[i + 1]) continue
                return false
            }
            return false
        }
    }
    return true
}

private const val MINIMUM_SUPPLEMENTARY_CODE_POINT = 0x10000

private fun Int.charCount() = if (this >= MINIMUM_SUPPLEMENTARY_CODE_POINT) 2 else 1
