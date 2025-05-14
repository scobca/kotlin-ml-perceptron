package org.itmo.kotlinmlperceptron

import org.itmo.kotlinmlperceptron.functions.createPerceptron
import org.itmo.kotlinmlperceptron.functions.train
import org.itmo.kotlinmlperceptron.structure.InputData
import org.itmo.kotlinmlperceptron.structure.ProfessionVectors
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinMlPerceptronApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        val perceptron = createPerceptron()

        val inputs = InputData.inputs
        val targets = listOf(
            ProfessionVectors.backend,
            ProfessionVectors.frontend,
            ProfessionVectors.backend,
            ProfessionVectors.designer,
            ProfessionVectors.frontend,
            ProfessionVectors.backend,
            ProfessionVectors.frontend,
        )

        train(perceptron, inputs, targets, 10000, 0.1)

        val newUserInput = doubleArrayOf(
            5.0, 1.0406,
            10.0, 1.9526000000000001,
            0.3333333333333333, 0.0,
            7.0, 0.0,
            8.0, 0.0,
            14.666666666666666, 1059.0,
            0.0, 0.0,
            3.0, 0.0980076246306344,
            3.0, 0.08821730749973736,
            1.5, 707.0,
            4.888888888888889, 366.44444444444446,
            0.0, 0.0
        )
        val prediction = perceptron.predict(newUserInput)

        val professions = listOf("Designer", "Frontend", "Backend")
        val maxIndex = prediction.indices.maxByOrNull { prediction[it] } ?: -1

        println("Predicted profession: ${professions[maxIndex]} with confidence ${prediction[maxIndex]}")
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinMlPerceptronApplication>(*args)
}
