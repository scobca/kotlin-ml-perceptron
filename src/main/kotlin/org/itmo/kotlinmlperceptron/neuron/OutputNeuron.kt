package org.itmo.kotlinmlperceptron.neuron

import org.itmo.kotlinmlperceptron.functions.activation.ReLU
import org.springframework.stereotype.Component

@Component
class OutputNeuron(private val input: List<Pair<Double, Double>>) : AbstractNeuron() {
    override val func: Double.() -> Double = ReLU()
}