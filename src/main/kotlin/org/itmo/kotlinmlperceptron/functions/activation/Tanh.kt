package org.itmo.kotlinmlperceptron.functions.activation

import org.itmo.kotlinmlperceptron.functions.round
import kotlin.math.tanh

object Tanh : AbstractActivationFunction() {
    override operator fun invoke(): Double.() -> Double = {
        tanh(this).round()
    }
}