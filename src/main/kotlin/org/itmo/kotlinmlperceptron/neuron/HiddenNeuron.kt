package org.itmo.kotlinmlperceptron.neuron

import org.itmo.kotlinmlperceptron.functions.activation.Sigmoid
import org.springframework.stereotype.Component

@Component
class HiddenNeuron(private val input: List<Pair<Double, Double>>) : AbstractNeuron() {
    override val func: Double.() -> Double = Sigmoid()
}