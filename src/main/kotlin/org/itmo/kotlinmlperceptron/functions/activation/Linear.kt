package org.itmo.kotlinmlperceptron.functions.activation

object Linear : AbstractActivationFunction() {
    override operator fun invoke(): Double.() -> Double = {
        this
    }
}