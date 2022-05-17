package View;

import controller.SubjectController;
import javafx.scene.layout.AnchorPane;

public class SubjectView extends AnchorPane {
    private static SubjectController controller;

    public static SubjectController getController() {
        controller = SubjectController.getInstance();
        return controller;
    }
}
