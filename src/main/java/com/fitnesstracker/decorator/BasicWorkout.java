/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnesstracker.decorator;

/**
 *
 * @author omnia zedan
 */
public class BasicWorkout implements Workout {

    @Override
    public String getDescription() {
        return "This cardio workout is designed to increase heart rate and improve cardiovascular endurance."
                + " It includes dynamic exercises such as jumping jacks, running in place, high knees, "
                + "and burpees. "
                + "The workout helps burn calories, boost energy levels, "
                + "and strengthen the heart and lungs. It is suitable for all fitness levels and can be "
                + "adjusted by changing the intensity or duration of the exercises.";
    }

    @Override
    public double getCalories() {
        return 200;
    }}
