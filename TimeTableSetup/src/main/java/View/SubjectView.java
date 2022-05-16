package View;

import controller.SubjectController;

public class SubjectView {
    private static SubjectController controller;

    public static SubjectController getController() {
        controller = SubjectController.getInstance();
        return controller;
    }
}
