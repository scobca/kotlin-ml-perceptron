package org.itmo.kotlinmlperceptron.functions.activation

import org.itmo.kotlinmlperceptron.functions.round
import kotlin.math.exp

object Sigmoid : AbstractActivationFunction() {
    override operator fun invoke(): Double.() -> Double = {
        (1 / (1 + exp(-this))).round()
    }
}