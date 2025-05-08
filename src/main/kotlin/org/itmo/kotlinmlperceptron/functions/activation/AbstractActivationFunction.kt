package org.itmo.kotlinmlperceptron.functions.activation

abstract class AbstractActivationFunction {
    abstract fun invoke(): Double.() -> Double
}