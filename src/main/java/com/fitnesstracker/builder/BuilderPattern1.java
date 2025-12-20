
package com.fitnesstracker.builder;

public class BuilderPattern1 {
    public static void main(String[] args) {
        
        FitnessPlan customPlan = new FitnessPlanBuilder()
                .setId(1)
                .setPlanName("Custom Plan")
                .setDuration(45)
                .setHasCardio(true)
                .setHasStrengthTraining(true)
                .setHasStretching(false)
                .setCaloriesBurned(350)
                .build();

        System.out.println(customPlan);
 
        
        FitnessPlanDirector director = new FitnessPlanDirector(new FitnessPlanBuilder());
        FitnessPlan beginnerPlan = director.constructBeginnerPlan();
        FitnessPlan mediumPlan   = director.constructMediumPlan();
        FitnessPlan advancedPlan = director.constructAdvancedPlan();
       
        System.out.println(beginnerPlan);
        System.out.println(mediumPlan);
        System.out.println(advancedPlan);
    }
    
}