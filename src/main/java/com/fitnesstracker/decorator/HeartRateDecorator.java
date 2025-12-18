/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnesstracker.decorator;

/**
 *
 * @author omnia zedan
 */
public class HeartRateDecorator extends WorkoutDecorator {

    public HeartRateDecorator(Workout workout) {
        super(workout);
    }

    @Override
    public String getDescription() {
        return workout.getDescription() + "  Real-Time Heart Rate Monitoring ";
    }

    @Override
    public double getCalories() {
        return workout.getCalories() + 30;
    }
}
