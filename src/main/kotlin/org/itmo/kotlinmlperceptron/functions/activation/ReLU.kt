package org.itmo.kotlinmlperceptron.functions.activation

object ReLU : AbstractActivationFunction() {
    override operator fun invoke(): Double.() -> Double = {
        val x = this
        if (x > 0) x else 0.0
    }
}