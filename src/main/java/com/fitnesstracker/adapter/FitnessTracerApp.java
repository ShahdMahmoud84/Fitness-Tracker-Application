
package com.fitnesstracker.adapter;


public class FitnessTracerApp {
    private FitnessData fitnessData;

    public FitnessTracerApp(FitnessData fitnessData) {
        this.fitnessData = fitnessData;
    }

    public void displayReport() {
        System.out.println("Steps: " + fitnessData.getDailySteps());
        System.out.println("Calories Burned: " + fitnessData.getBurnedCalories());
    } 
}
