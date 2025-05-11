package org.itmo.kotlinmlperceptron.structure

import org.itmo.kotlinmlperceptron.structure.neuron.AbstractNeuron
import org.springframework.stereotype.Component

@Component
class Layer(val neurons: List<AbstractNeuron>) {
    fun forward(inputs: DoubleArray): DoubleArray {
        return neurons.map { it.activate(inputs) }.toDoubleArray()
    }
}