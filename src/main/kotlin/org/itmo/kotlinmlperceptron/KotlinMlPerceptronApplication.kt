package org.itmo.kotlinmlperceptron

import org.itmo.kotlinmlperceptron.dto.PredictionResponseDto
import org.itmo.kotlinmlperceptron.functions.createPerceptron
import org.itmo.kotlinmlperceptron.functions.train
import org.itmo.kotlinmlperceptron.structure.InputData
import org.itmo.kotlinmlperceptron.structure.ProfessionVectors
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/perceptron")
class KotlinMlPerceptronApplication : CommandLineRunner {
    private var perceptron: Perceptron? = null

    override fun run(vararg args: String?) {
        perceptron = createPerceptron()

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

        perceptron?.let { train(it, inputs, targets, 10000, 0.1) }
    }

    @PostMapping("/predict")
    fun predict(@RequestBody input: DoubleArray): Any {
        if (perceptron != null) {
            val prediction = perceptron!!.predict(input)
            val professions = listOf("Designer", "Frontend", "Backend")
            val maxIndex = prediction.indices.maxByOrNull { prediction[it] } ?: 0
            println(PredictionResponseDto(professions[maxIndex], prediction[maxIndex]))

            var answer = mutableListOf<PredictionResponseDto>()
            answer.add(PredictionResponseDto(professions[0], prediction[0]))
            answer.add(PredictionResponseDto(professions[1], prediction[1]))
            answer.add(PredictionResponseDto(professions[2], prediction[2]))

            println(answer)
            return answer
        } else {
            return PredictionResponseDto("0", 0.0)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinMlPerceptronApplication>(*args)
}
