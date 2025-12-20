package com.fitnesstracker.factory;

public class CardioExercise implements Exercise {
    private String name;
    private int duration;
    
    public CardioExercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    
    @Override
    public void perform() {
        System.out.println("Performing Cardio Exercise: " + name);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories burned: " + (duration * 10));
    }
    
   // @Override
   // public String getDetails() {
        //return "Cardio - " + name + " (" + duration + " min)";
   // }
}