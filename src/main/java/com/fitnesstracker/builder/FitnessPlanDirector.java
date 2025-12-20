
package com.fitnesstracker.builder;
public class FitnessPlanDirector {
    private FitnessPlanBuilder builder;

    public FitnessPlanDirector(FitnessPlanBuilder builder) {
        this.builder = builder;
    }

  
    public FitnessPlan constructBeginnerPlan() {
        return builder
                .setId(2)
                .setPlanName("Beginner Plan")
                .setDuration(25)
                .setHasCardio(true)
                .setHasStrengthTraining(false)
                .setHasStretching(true)
                .setCaloriesBurned(150)
                .build();
    }
   
    public FitnessPlan constructMediumPlan() {
        return builder
                .setId(3)
                .setPlanName("Medium Plan")
                .setDuration(40)
                .setHasCardio(true)
                .setHasStrengthTraining(true)
                .setHasStretching(true)
                .setCaloriesBurned(300)
                .build();
    }
    
    public FitnessPlan constructAdvancedPlan() {
        return builder
                .setId(4)
                .setPlanName("Advanced Plan")
                .setDuration(60)
                .setHasCardio(true)
                .setHasStrengthTraining(true)
                .setHasStretching(true)
                .setCaloriesBurned(500)
                .build();
    }
}
