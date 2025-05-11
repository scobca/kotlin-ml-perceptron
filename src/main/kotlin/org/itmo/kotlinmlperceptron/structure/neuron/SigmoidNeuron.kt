package org.itmo.kotlinmlperceptron.structure.neuron

import org.itmo.kotlinmlperceptron.functions.Activations

class SigmoidNeuron(inputSize: Int) : AbstractNeuron(inputSize) {
    override val activation = Activations.sigmoid
    override val activationDerivative = Activations.sigmoidDerivative
}