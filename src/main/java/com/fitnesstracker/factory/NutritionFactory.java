package com.fitnesstracker.factory;

/**
 * Nutrition Factory - creates different nutrition plans
 */
public class NutritionFactory {

    public static NutritionPlan createPlan(String goal) {

        switch (goal.toUpperCase()) {

            case "WEIGHT_LOSS":
                return new WeightLossPlan();

            case "MUSCLE_GAIN":
                return new MuscleGainPlan();

            default:
                return null;
        }
    }
}
