package View;

import controller.SubjectController;
import controller.TimetableController;

public class TimeTableView {
    private static TimetableController controller;

    public static TimetableController getController() {
        controller = TimetableController.getInstance();
        return controller;
    }
}
