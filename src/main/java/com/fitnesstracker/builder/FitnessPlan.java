
package builderpattern1;
public class FitnessPlan {
   private int id;
    private String planName;
    private int duration; 
    private boolean hasCardio;
    private boolean hasStrengthTraining;
    private boolean hasStretching;
    private double caloriesBurned;

    public FitnessPlan(int id, String planName, int duration, boolean hasCardio, boolean hasStrengthTraining, boolean hasStretching, double caloriesBurned) {
        this.id = id;
        this.planName = planName;
        this.duration = duration;
        this.hasCardio = hasCardio;
        this.hasStrengthTraining = hasStrengthTraining;
        this.hasStretching = hasStretching;
        this.caloriesBurned = caloriesBurned;
    }
    @Override
    public String toString() {
        return "FitnessPlan{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", duration=" + duration +
                ", hasCardio=" + hasCardio +
                ", hasStrengthTraining=" + hasStrengthTraining +
                ", hasStretching=" + hasStretching +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
