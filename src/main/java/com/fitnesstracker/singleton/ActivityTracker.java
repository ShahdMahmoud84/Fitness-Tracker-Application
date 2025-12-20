package com.fitnesstracker.singleton;

import java.util.ArrayList;

import java.util.List;

public class ActivityTracker {

    // نسخة وحيدة من الكلاس

    private static ActivityTracker instance;

    // قائمة لتخزين الأنشطة

    private List<String> activities;

    // الكونستركتور الخاص Private لمنع إنشاء نسخ أخرى

    private ActivityTracker() {

        activities = new ArrayList<>();

    }

    // طريقة الوصول إلى النسخة الوحيدة

    public static ActivityTracker getInstance() {

        if (instance == null) {

            instance = new ActivityTracker();

        }

        return instance;

    }

    // إضافة نشاط

    public void addActivity(String activity) {

        activities.add(activity);

    }

    // عرض الأنشطة

    public void showActivities() {

        System.out.println("User Activities:");

        for (String activity : activities) {

            System.out.println("- " + activity);

        }

    }

}