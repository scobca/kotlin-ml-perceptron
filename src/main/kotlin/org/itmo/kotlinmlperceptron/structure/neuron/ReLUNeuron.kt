package org.itmo.kotlinmlperceptron.structure.neuron

import org.itmo.kotlinmlperceptron.functions.Activations

class ReLUNeuron(inputSize: Int) : AbstractNeuron(inputSize) {
    override val activation = Activations.relu
    override val activationDerivative = Activations.reluDerivative
}