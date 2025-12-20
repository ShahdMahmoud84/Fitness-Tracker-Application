package com.fitnesstracker.singleton;

public class SingletonDP {

    

    public static void main(String[] args) {

        // الحصول على النسخة الوحيدة من Activity Tracker

        ActivityTracker tracker = ActivityTracker.getInstance();

        tracker.addActivity("Running 5 km");

        tracker.addActivity("Cycling 10 km");

        // الحصول على النسخة الوحيدة من Goal Manager

        GoalManager goals = GoalManager.getInstance();

        goals.addGoal("Lose 5 kg in 2 months");

        goals.addGoal("Build muscle strength");

        // عرض البيانات

        tracker.showActivities();

        goals.showGoals();

    }

}