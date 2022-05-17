package View;

import controller.SubjectController;
import controller.TableController;

public class TableView {
    private static TableController controller;

    public static TableController getController() {
        controller = TableController.getInstance();
        return controller;
    }
}
