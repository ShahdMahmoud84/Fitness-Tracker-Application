/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnesstracker.decorator;

/**
 *
 * @author omnia zedan
 */
public class DietPlanDecorator extends WorkoutDecorator {

    public DietPlanDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + " The included diet plan supports the workout by providing balanced meals rich in protein,"
                + " healthy carbohydrates, and essential vitamins."
                + " It helps with energy recovery, muscle maintenance, "
                + "and achieving fitness goals such as weight loss or improved endurance.";
    }

    @Override
    public double getCalories() {
        return workout.getCalories() + 20;
    }
}