package builderpattern1;
public class FitnessPlanBuilder {
     private int id;
    private String planName;
    private int duration; 
    private boolean hasCardio;
    private boolean hasStrengthTraining;
    private boolean hasStretching;
    private double caloriesBurned;

    public FitnessPlanBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FitnessPlanBuilder setPlanName(String planName) {
        this.planName = planName;
        return this;
    }
    
    public FitnessPlanBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public FitnessPlanBuilder setHasCardio(boolean hasCardio) {
        this.hasCardio = hasCardio;
        return this;
    }

     public FitnessPlanBuilder setHasStrengthTraining(boolean hasStrengthTraining) {
        this.hasStrengthTraining = hasStrengthTraining;
        return this;
    }

    public FitnessPlanBuilder setHasStretching(boolean hasStretching) {
        this.hasStretching = hasStretching;
        return this;
    }

    public FitnessPlanBuilder setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
        return this;
    }
    
    public FitnessPlan build() {
        return new FitnessPlan(id, planName, duration, hasCardio, hasStrengthTraining, hasStretching, caloriesBurned);
    }
    
}
