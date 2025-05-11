package org.itmo.kotlinmlperceptron.functions

import org.itmo.kotlinmlperceptron.Perceptron


fun train(
    perceptron: Perceptron,
    inputs: List<DoubleArray>,
    targets: List<DoubleArray>,
    epochs: Int,
    learningRate: Double
) {
    for (epoch in 1..epochs) {
        var totalLoss = 0.0

        for ((x, y) in inputs.zip(targets)) {
            val layerOutputs = perceptron.forward(x)

            val outputs = layerOutputs.last()
            val errors = DoubleArray(outputs.size) { i -> y[i] - outputs[i] }

            totalLoss += errors.sumOf { it * it } / errors.size

            val deltas = mutableListOf<DoubleArray>()
            val outputLayer = perceptron.layers.last()
            val outputDelta = DoubleArray(outputLayer.neurons.size)

            for (i in outputLayer.neurons.indices) {
                val neuron = outputLayer.neurons[i]
                val out = outputs[i]
                outputDelta[i] = errors[i] * neuron.activationDerivative(out)
            }
            deltas.add(outputDelta)

            for (layerIndex in perceptron.layers.size - 2 downTo 0) {
                val layer = perceptron.layers[layerIndex]
                val nextLayer = perceptron.layers[layerIndex + 1]
                val layerOutput = layerOutputs[layerIndex + 1]
                val delta = DoubleArray(layer.neurons.size)

                for (i in layer.neurons.indices) {
                    var error = 0.0
                    for (j in nextLayer.neurons.indices) {
                        error += nextLayer.neurons[j].weights[i] * deltas[0][j]
                    }
                    val neuron = layer.neurons[i]
                    delta[i] = error * neuron.activationDerivative(layerOutput[i])
                }
                deltas.add(0, delta)
            }

            for (layerIndex in perceptron.layers.indices) {
                val layer = perceptron.layers[layerIndex]
                val inputToUse = layerOutputs[layerIndex]
                val delta = deltas[layerIndex]

                for (neuronIndex in layer.neurons.indices) {
                    val neuron = layer.neurons[neuronIndex]
                    for (wIndex in neuron.weights.indices) {
                        neuron.weights[wIndex] += learningRate * delta[neuronIndex] * inputToUse[wIndex]
                    }
                    neuron.bias += learningRate * delta[neuronIndex]
                }
            }
        }

        println("Epoch $epoch, Loss = ${totalLoss / inputs.size}")
    }
}

