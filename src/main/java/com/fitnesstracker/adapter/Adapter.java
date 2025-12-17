
package com.fitnesstracker.adapter;


public class Adapter {

    public static void main(String[] args) {
      SmartWatchAPI smartWatchAPI = new SmartWatchAPI();
        FitnessData adapter = new SmartWatchAdapter(smartWatchAPI);

        FitnessTracerApp app = new FitnessTracerApp(adapter);
        app.displayReport();  
    }
} 

