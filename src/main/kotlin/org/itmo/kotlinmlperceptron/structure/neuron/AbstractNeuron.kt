package org.itmo.kotlinmlperceptron.structure.neuron

abstract class AbstractNeuron(
    val inputSize: Int,
    var weights: DoubleArray = DoubleArray(inputSize) { (Math.random() - 0.5) * 0.1 },
    var bias: Double = 0.0
) {
    abstract val activation: (Double) -> Double
    abstract val activationDerivative: (Double) -> Double

    fun activate(inputs: DoubleArray): Double {
        require(inputs.size == inputSize)
        val z = weights.zip(inputs).sumOf { (w, i) -> w * i } + bias
        return activation(z)
    }
}