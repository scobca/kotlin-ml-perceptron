package org.itmo.kotlinmlperceptron

import org.itmo.kotlinmlperceptron.structure.Layer

class Perceptron(val layers: List<Layer>) {
    fun forward(inputs: DoubleArray): List<DoubleArray> {
        val outputs = mutableListOf<DoubleArray>()
        var currentInput = inputs

        outputs.add(currentInput)

        for (layer in layers) {
            currentInput = layer.forward(currentInput)
            outputs.add(currentInput)
        }

        return outputs
    }

    fun predict(inputs: DoubleArray): DoubleArray {
        return forward(inputs).last()
    }
}