/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnesstracker.decorator;

/**
 *
 * @author omnia zedan
 */
public class Fitness {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Workout workout = new BasicWorkout();

        workout = new CaloriesTrackerDecorator(workout);
        workout = new HeartRateDecorator(workout);
        workout = new DietPlanDecorator(workout);

        System.out.println(workout.getDescription());
        System.out.println("Total Calories Burned: " + workout.getCalories());
    }
}
