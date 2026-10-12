
package com.example.workout.data

import com.example.workout.model.Exercise

object WorkoutData {                //This section includes workout exercises and information.

    val exercises = listOf(
        Exercise("Push-ups", "Push your body up and down.", "Chest", "None", 3, 12),
        Exercise("Bench Press", "Push a barbell up from your chest.", "Chest", "Barbell", 3, 10),

        Exercise("Pull-ups", "Pull your body up to the bar.", "Back", "Pull-up bar", 3, 8),
        Exercise("Dumbbell Row", "Pull a dumbbell toward your body.", "Back", "Dumbbell", 3, 12),

        Exercise("Dumbbell Curl", "Lift dumbbells by bending your elbows.", "Biceps", "Dumbbells", 3, 12),
        Exercise("Hammer Curl", "Lift dumbbells with your palms facing inward.", "Biceps", "Dumbbells", 3, 12),

        Exercise("Triceps Dips", "Lower and raise your body using your arms.", "Triceps", "Parallel bars", 3, 10),
        Exercise("Triceps Extension", "Straighten your arms to lift a weight.", "Triceps", "Dumbbell", 3, 12),

        Exercise("Shoulder Press", "Push weights above your head.", "Shoulders", "Dumbbells", 3, 10),
        Exercise("Lateral Raise", "Raise your arms out to the sides.", "Shoulders", "Dumbbells", 3, 12),

        Exercise("Squats", "Bend your knees and lower your body.", "Legs", "None", 3, 15),
        Exercise("Lunges", "Step forward and bend both knees.", "Legs", "None", 3, 10),

        Exercise("Crunches", "Lift your upper body slightly to train your abs.", "Abs", "None", 3, 15),
        Exercise("Plank", "Hold your body straight on your elbows and toes.", "Abs", "None", 3, 30),

        Exercise("Wrist Curls", "Move your wrists upward while holding weights.", "Forearms", "Dumbbells", 3, 12),
        Exercise("Reverse Wrist Curls", "Lift the weights by moving your wrists upward.", "Forearms", "Dumbbells", 3, 12)
    )
}
