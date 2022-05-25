package View;

import controller.LeftPaneController;

public class LeftPaneView {
    private static LeftPaneController controller;

    public static LeftPaneController getController() {
        controller = LeftPaneController.getInstance();
        return controller;
    }
}
