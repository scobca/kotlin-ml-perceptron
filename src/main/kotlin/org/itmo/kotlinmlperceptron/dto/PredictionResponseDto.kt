package org.itmo.kotlinmlperceptron.dto

data class PredictionResponseDto(
    val profession: String,
    val confidence: Double,
)
