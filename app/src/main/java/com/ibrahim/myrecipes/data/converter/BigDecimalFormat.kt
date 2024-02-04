package com.ibrahim.myrecipes.data.converter

import java.text.DecimalFormatSymbols

class DecimalFormatter(
    symbols: DecimalFormatSymbols = DecimalFormatSymbols.getInstance()
) {

    private val thousandsSeparator = symbols.groupingSeparator
    private val decimalSeparator = symbols.decimalSeparator

    fun cleanup(input: String): String {
        if (input.matches("\\D".toRegex())) return ""
        if (input.matches("0+".toRegex())) return "0"

        val sb = StringBuilder()

        var hasDecimalSep = false

        for ((index, char) in input.withIndex()) {
            if (char.isDigit()) {
                sb.append(char)
                continue
            }
            if (char == decimalSeparator && !hasDecimalSep) {
                // Allow decimal separator at the start of the input string or after a digit
                if (index == 0 || (index > 0 && sb[index - 1].isDigit())) {
                    sb.append(char)
                    hasDecimalSep = true
                }
            }
        }

        // Ensure that the last character is not a decimal separator if it's not followed by a digit
        if (sb.isNotEmpty() && sb.last() == decimalSeparator && (sb.length == 1 || !sb[sb.length - 2].isDigit())) {
            sb.deleteCharAt(sb.length - 1)
        }

        return sb.toString()
    }




}