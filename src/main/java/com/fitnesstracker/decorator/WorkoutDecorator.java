/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnesstracker.decorator;

/**
 *
 * @author omnia zedan
 */
public class WorkoutDecorator implements Workout {

    protected Workout workout;

    public WorkoutDecorator(Workout workout) {
        this.workout = workout;
    }

    @Override
    public String getDescription() {
        return workout.getDescription();
    }

    @Override
    public double getCalories() {
        return workout.getCalories();
    }
}