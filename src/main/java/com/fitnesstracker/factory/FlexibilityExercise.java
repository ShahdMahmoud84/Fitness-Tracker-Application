package com.fitnesstracker.factory;

public class FlexibilityExercise implements Exercise {
    private String name;
    private int duration;
    
    public FlexibilityExercise(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    
    @Override
    public void perform() {
        System.out.println("Performing Flexibility Exercise: " + name);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories burned: " + (duration * 3));
    }
    
 //   @Override
  //  public String getDetails() {
     //   return "Flexibility - " + name + " (" + duration + " min)";
   // }
}