package View;

import controller.HomeController;
import controller.ListSubjectController;

public class ListSubjectView {
    private static ListSubjectController controller;

    public static ListSubjectController getController() {
        controller = ListSubjectController.getInstance();
        return controller;
    }
}
