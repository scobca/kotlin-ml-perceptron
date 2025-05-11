package org.itmo.kotlinmlperceptron.utils

import org.springframework.beans.factory.annotation.Value
import java.io.File

class FileReader {
    @Value("\${files.hiddenMatrix}")
    private lateinit var hiddenMatrix: String

    fun getHiddenMatrix(): List<List<Double>> {
        val file = File(hiddenMatrix)

        if (file.exists()) {
            val line = File(hiddenMatrix).readText().trim()

            val trimmed = line.removePrefix("[").removeSuffix("]")
            val rows = trimmed.split("], [")

            return rows.map { row ->
                val cleanRow = row.removePrefix("[").removeSuffix("]")
                cleanRow.split(",").map { it.trim().toDouble() }
            }
        } else {
            println("File doesn't exist")
            return emptyList()
        }
    }
}