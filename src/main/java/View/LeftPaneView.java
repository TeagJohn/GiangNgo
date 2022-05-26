package View;

import controller.LeftPaneController;
import model.Subject;

public class LeftPaneView {
    private static LeftPaneController controller;

    public static LeftPaneController getController() {
        controller = LeftPaneController.getInstance();
        return controller;
    }

    public static void addSubject(SubjectView view) {
        controller.getListView().getItems().add(view);
    }
}
