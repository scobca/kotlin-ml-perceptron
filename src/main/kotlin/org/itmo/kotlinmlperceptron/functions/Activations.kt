package org.itmo.kotlinmlperceptron.functions

import kotlin.math.exp

object Activations {
    val sigmoid: (Double) -> Double = { 1.0 / (1.0 + exp(-it)) }
    val sigmoidDerivative: (Double) -> Double = { s -> s * (1 - s) }

    val relu: (Double) -> Double = { if (it > 0) it else 0.0 }
    val reluDerivative: (Double) -> Double = { if (it > 0) 1.0 else 0.0 }

    val linear: (Double) -> Double = { it }
    val linearDerivative: (Double) -> Double = { 1.0 }
}