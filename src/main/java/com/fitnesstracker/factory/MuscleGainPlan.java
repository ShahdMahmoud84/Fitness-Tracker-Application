package com.fitnesstracker.factory;

public class MuscleGainPlan implements NutritionPlan {
    
    @Override
    public void displayPlan() {
        System.out.println("\n Muscle Gain Nutrition Plan");
        System.out.println("Goal: Build muscle through caloric surplus");
        System.out.println("Daily Calories: 2800");
        System.out.println("Macros: Protein 35%, Carbs 45%, Fats 20%");
    }
    
   // @Override
   // public String getGoal() {
    //    return "Muscle Gain";
   // }
}