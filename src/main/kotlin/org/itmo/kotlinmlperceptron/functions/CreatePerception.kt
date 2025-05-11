package org.itmo.kotlinmlperceptron.functions

import org.itmo.kotlinmlperceptron.Perceptron
import org.itmo.kotlinmlperceptron.structure.neuron.SigmoidNeuron
import org.itmo.kotlinmlperceptron.structure.Layer

fun createPerceptron(): Perceptron {
    val inputSize = 24
    val hiddenSize = 16
    val outputSize = 3

    val hiddenLayer = Layer(List(hiddenSize) { SigmoidNeuron(inputSize) })
    val outputLayer = Layer(List(outputSize) { SigmoidNeuron(hiddenSize) })

    return Perceptron(listOf(hiddenLayer, outputLayer))
}
