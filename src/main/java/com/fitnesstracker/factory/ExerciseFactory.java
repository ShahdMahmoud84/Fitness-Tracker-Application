package com.fitnesstracker.factory;


public class ExerciseFactory {

    public static Exercise createExercise(String type, String name, int duration) {
        switch (type.toUpperCase()) {
            case "CARDIO":
                return new CardioExercise(name, duration);
            case "STRENGTH":
                return new StrengthExercise(name, duration);
            case "FLEXIBILITY":
                return new FlexibilityExercise(name, duration);
            default:
                return null;
        }
    }
}
