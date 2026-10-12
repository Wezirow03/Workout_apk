
package com.example.workout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workout.data.WorkoutData
import com.example.workout.model.Exercise
import com.example.workout.ui.theme.WorkoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WorkoutTheme {
                WorkoutApp()
            }
        }
    }
}

                         // WorkoutApp manages the app screens and user selections.
@Composable
fun WorkoutApp() {
                         // Stores the selected muscle group and exercise.

    var selectedGroup by remember { mutableStateOf<String?>(null) }
    var selectedExercise by remember { mutableStateOf<Exercise?>(null) }

    val groups = listOf(
        "Chest", "Back", "Biceps", "Triceps",
        "Shoulders", "Legs", "Abs", "Forearms"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
                                   // Shows the selected exercise details.
        if (selectedExercise != null) {
            Button(
                onClick = { selectedExercise = null }
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = selectedExercise!!.title,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Description: ${selectedExercise!!.description}")
            Text("Muscle group: ${selectedExercise!!.muscleGroup}")
            Text("Equipment: ${selectedExercise!!.equipment}")
            Text("Sets: ${selectedExercise!!.sets}")

            val exercise = selectedExercise!!
            Text(
                if (exercise.title == "Plank") {
                    "Duration: ${exercise.repetitions} seconds"
                } else {
                    "Repetitions: ${exercise.repetitions}"
                }
            )
                             // Exercise details and the Back button.

        } else if (selectedGroup != null) {
            Button(
                onClick = { selectedGroup = null }
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = selectedGroup!!,
                style = MaterialTheme.typography.headlineMedium
            )
                         // Displays the items in a scrollable list.

            LazyColumn {
                items(
                    WorkoutData.exercises.filter {
                        it.muscleGroup == selectedGroup
                    }
                ) { exercise ->
                                  // Opens the selected muscle group.
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                selectedExercise = exercise
                            }
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = exercise.title,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text("Sets: ${exercise.sets}")
                            Text("Equipment: ${exercise.equipment}")
                        }
                    }
                }
            }

        }
                                         // Shows all muscle groups.
        else {
            Text(
                text = "Workout App",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Choose a muscle group")

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(groups) { group ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                selectedGroup = group
                            }
                    ) {
                        Text(
                            text = group,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
