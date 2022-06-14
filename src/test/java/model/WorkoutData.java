package model;

import lombok.Getter;

@Getter
public class WorkoutData {

    private String timeOfDay = "09:00 AM";
    private String nameOfWorkout = "Jogging";
    private String workoutDescription = "Jogging is a form of trotting or running at a slow or leisurely pace";
    private String distance = "8";
    private String duration = "01:00:05";
    private String perceivedEffort = "Max Effort";

    public WorkoutData() {
    }
}
