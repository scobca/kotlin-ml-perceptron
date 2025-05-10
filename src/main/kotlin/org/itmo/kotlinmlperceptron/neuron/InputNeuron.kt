package org.itmo.kotlinmlperceptron.neuron

import org.itmo.kotlinmlperceptron.functions.activation.Linear
import org.springframework.stereotype.Component

@Component
class InputNeuron(private val input: List<Pair<Double, Double>>) : AbstractNeuron(input) {
    override val func: Double.() -> Double = Linear()
}