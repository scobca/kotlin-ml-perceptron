package org.itmo.kotlinmlperceptron.functions

import kotlin.math.pow

fun Double.round(decimals: Int = 6): Double {
    val multiplier = 10.0.pow(decimals)
    return kotlin.math.round((this * multiplier)) / multiplier
}