
package com.example.workout.model

data class Exercise(
    val title: String,
    val description: String,
    val muscleGroup: String,
    val equipment: String,
    val sets: Int,
    val repetitions: Int
)
