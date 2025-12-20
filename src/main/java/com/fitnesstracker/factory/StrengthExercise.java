package com.fitnesstracker.factory;

public class StrengthExercise implements Exercise {
    private String name;
    private int duration;
    
    public StrengthExercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    
    @Override
    public void perform() {
        System.out.println("Performing Strength Exercise: " + name);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories burned: " + (duration * 8));
    }
    
    //@Override
   // public String getDetails() {
       // return "Strength - " + name + " (" + duration + " min)";
   // }
}