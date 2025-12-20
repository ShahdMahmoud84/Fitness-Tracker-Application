package com.fitnesstracker.main;

// Singleton imports
import com.fitnesstracker.singleton.ActivityTracker;
import com.fitnesstracker.singleton.GoalManager;

// Builder imports
import com.fitnesstracker.builder.FitnessPlan;
import com.fitnesstracker.builder.FitnessPlanBuilder;
import com.fitnesstracker.builder.FitnessPlanDirector;

// Factory imports
import com.fitnesstracker.factory.Exercise;
import com.fitnesstracker.factory.ExerciseFactory;
import com.fitnesstracker.factory.NutritionPlan;
import com.fitnesstracker.factory.NutritionFactory;

// Adapter imports
import com.fitnesstracker.adapter.SmartWatchAPI;
import com.fitnesstracker.adapter.SmartWatchAdapter;
import com.fitnesstracker.adapter.FitnessData;
import com.fitnesstracker.adapter.FitnessTracerApp;

// Decorator imports
import com.fitnesstracker.decorator.BasicWorkout;
import com.fitnesstracker.decorator.Workout;
import com.fitnesstracker.decorator.CaloriesTrackerDecorator;
import com.fitnesstracker.decorator.HeartRateDecorator;
import com.fitnesstracker.decorator.DietPlanDecorator;

public class FitnessTrackerApp {

    public static void main(String[] args) {
        System.out.println("FITNESS TRACKER APPLICATION");
        System.out.println("All Design Patterns Demo\n");

        // ===== SINGLETON PATTERN =====
        System.out.println("SINGLETON PATTERN: ");
        ActivityTracker tracker = ActivityTracker.getInstance();
        tracker.addActivity("Running 5 km");
        tracker.addActivity("Cycling 10 km");
        tracker.showActivities();

        System.out.println();
        GoalManager goals = GoalManager.getInstance();
        goals.addGoal("Lose 5 kg in 2 months");
        goals.addGoal("Build muscle strength");
        goals.showGoals();

        // ===== BUILDER PATTERN =====
        System.out.println("\nBUILDER PATTERN: ");

        // Custom plan
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

        // Director plans
        FitnessPlanDirector director = new FitnessPlanDirector(new FitnessPlanBuilder());
        FitnessPlan beginnerPlan = director.constructBeginnerPlan();
        System.out.println(beginnerPlan);

        // ===== FACTORY PATTERN =====
        System.out.println("\nFACTORY PATTERN :");
        System.out.println("Creating Exercises:\n");

        Exercise running = ExerciseFactory.createExercise("CARDIO", "Running", 30);
        running.perform();

        System.out.println();
        Exercise weightLifting = ExerciseFactory.createExercise("STRENGTH", "Weight Lifting", 45);
        weightLifting.perform();
        System.out.println();
        Exercise yoga = ExerciseFactory.createExercise("FLEXIBILITY", "Yoga", 60);
        yoga.perform();
        System.out.println("\nCreating Nutrition Plans:");
        NutritionPlan weightLoss = NutritionFactory.createPlan("WEIGHT_LOSS");
        weightLoss.displayPlan();

        NutritionPlan muscleGain = NutritionFactory.createPlan("MUSCLE_GAIN");
        muscleGain.displayPlan();

        // ===== ADAPTER PATTERN =====
        System.out.println("\nADAPTER PATTERN: ");
        SmartWatchAPI smartWatchAPI = new SmartWatchAPI();
        FitnessData adapter = new SmartWatchAdapter(smartWatchAPI);
        FitnessTracerApp app = new FitnessTracerApp(adapter);
        app.displayReport();

        // ===== DECORATOR PATTERN =====
        System.out.println("\n DECORATOR PATTERN: ");
        Workout workout = new BasicWorkout();
        workout = new CaloriesTrackerDecorator(workout);
        workout = new HeartRateDecorator(workout);
        workout = new DietPlanDecorator(workout);

        System.out.println(workout.getDescription());
        System.out.println("Total Calories Burned: " + workout.getCalories());

        System.out.println("\n ALL PATTERNS WORKING! ");
    }
}
