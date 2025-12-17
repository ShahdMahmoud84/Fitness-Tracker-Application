package com.fitnesstracker.factory;

/**
 * Main class to test Factory Pattern
 * Similar to Step 4 in PUBG example
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Fitness Tracker\n");
        
        // Test Exercise Factory
        System.out.println("Creating Exercises:\n");
        
        Exercise running = ExerciseFactory.createExercise("CARDIO", "Running", 30);
        running.perform();
        
        System.out.println();
        
        Exercise weightLifting = ExerciseFactory.createExercise("STRENGTH", "Weight Lifting", 45);
        weightLifting.perform();
        
        System.out.println();
        
        Exercise yoga = ExerciseFactory.createExercise("FLEXIBILITY", "Yoga", 60);
        yoga.perform();
        
        // Test Nutrition Factory
        System.out.println("\nCreating Nutrition Plans: ");
        
        NutritionPlan weightLoss = NutritionFactory.createPlan("WEIGHT_LOSS");
        weightLoss.displayPlan();
        
        NutritionPlan muscleGain = NutritionFactory.createPlan("MUSCLE_GAIN");
        muscleGain.displayPlan();
        
       
    }
}