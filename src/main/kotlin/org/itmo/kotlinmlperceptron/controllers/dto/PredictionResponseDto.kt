package org.itmo.kotlinmlperceptron.controllers.dto

data class PredictionResponseDto(
    val profession: String,
    val confidence: Double,
)
