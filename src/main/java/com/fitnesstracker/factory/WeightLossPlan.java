package com.fitnesstracker.factory;

public class WeightLossPlan implements NutritionPlan {
    
    @Override
    public void displayPlan() {
        System.out.println("\n Weight Loss Nutrition Plan");
        System.out.println("Goal: Lose weight through caloric deficit");
        System.out.println("Daily Calories: 1800");
        System.out.println("Macros: Protein 30%, Carbs 40%, Fats 30%");
    }
    
   // @Override
   // public String getGoal() {
       // return "Weight Loss";
    //}
}