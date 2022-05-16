package View;

import controller.HomeController;
import controller.SubjectController;

public class HomeView {
    private static HomeController controller;

    public static HomeController getController() {
        controller = HomeController.getInstance();
        return controller;
    }

}
