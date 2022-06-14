package service;

import lombok.extern.log4j.Log4j2;
import model.WorkoutData;
import page.AddWorkoutPage;
import page.DashboardPage;

@Log4j2
public class AddWorkoutPageService {

    private final AddWorkoutPage addWorkoutPage = new AddWorkoutPage();
    private final WorkoutData workoutData = new WorkoutData();

    public DashboardPage addNewRunWorkout(String runSubType) {
        try {
            addWorkoutPage.chooseRunActivity()
                    .chooseActivitySubType(runSubType)
                    .chooseTodayInCalendar()
                    .chooseTimeOfDay(workoutData.getTimeOfDay())
                    .fillInWorkoutName(workoutData.getNameOfWorkout())
                    .fillInWorkoutDescription(workoutData.getWorkoutDescription())
                    .fillInDistance(workoutData.getDistance())
                    .fillInDuration(workoutData.getDuration())
                    .clickTerribleFeelingsRadioButton()
                    .choosePerceivedEffort(workoutData.getPerceivedEffort())
                    .clickAddWorkoutButton();
        } catch (Exception exception) {
            log.error("New workout addition failed!");
        }
        return new DashboardPage();
    }

}
