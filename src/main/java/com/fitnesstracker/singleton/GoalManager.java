
package com.fitnesstracker.singleton;

import java.util.ArrayList;

import java.util.List;

  public class GoalManager {

    // نسخة وحيدة من الكلاس

    private static GoalManager instance;

    // قائمة لتخزين الأهداف

    private List<String> goals;

    // الكونستركتور الخاص Private لمنع إنشاء نسخ أخرى

    private GoalManager() {

        goals = new ArrayList<>();

    }

    // طريقة الوصول إلى النسخة الوحيدة

    public static GoalManager getInstance() {

        if (instance == null) {

            instance = new GoalManager();

        }

        return instance;

    }

    // إضافة هدف

    public void addGoal(String goal) {

        goals.add(goal);

    }

    // عرض الأهداف

    public void showGoals() {

        System.out.println("User Goals:");

        for (String goal : goals) {

            System.out.println("- " + goal);

        }

    }

}