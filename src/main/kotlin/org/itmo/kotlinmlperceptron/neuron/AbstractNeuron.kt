package org.itmo.kotlinmlperceptron.neuron

import org.itmo.kotlinmlperceptron.functions.round

abstract class AbstractNeuron(val inputNeuron: List<Pair<Double, Double>> = listOf()) {
    abstract val func: Double.() -> Double

    private object EMPTY
    private var output: Any = EMPTY
    private var q: Double = 0.0

    private fun getInput(): Double = inputNeuron.sumOf {
        (it.first * it.second).round()
    }

    fun activate(): Double {
        if (output == EMPTY) {
            output = getInput().run(func)
        }

        return output as Double
    }

    override fun toString(): String {
        return "Neuron { input = $inputNeuron, input = ${getInput()}, activated = ${activate()} }"
    }
}