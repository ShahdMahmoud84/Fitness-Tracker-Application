
package com.fitnesstracker.adapter;

public class SmartWatchAdapter implements FitnessData {
    private SmartWatchAPI smartWatchAPI;

    public SmartWatchAdapter(SmartWatchAPI smartWatchAPI) {
        this.smartWatchAPI = smartWatchAPI;
    }

    private int convertSteps(int stepsFromAPI) {
        return stepsFromAPI;
    }

    private double convertCalories(double caloriesFromAPI) {
        return caloriesFromAPI;
    }

    @Override
    public int getDailySteps() {
        return convertSteps(smartWatchAPI.fetchStepCount());
    }

    @Override
    public double getBurnedCalories() {
        return convertCalories(smartWatchAPI.fetchCaloriesBurned());
    }
}
