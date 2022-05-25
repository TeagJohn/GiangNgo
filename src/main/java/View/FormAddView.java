package View;

import controller.FormAddController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormAddView {
    private FormAddController controller;
    private static FormAddView instance;
    private Scene scene;
    private Stage stageForm;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public FormAddController getController() {
        controller = FormAddController.getInstance();
        return controller;
    }

    public Stage getStageForm() {
        return stageForm;
    }

    public void setStageForm(Stage stageForm) {
        this.stageForm = stageForm;
    }

    public static FormAddView getInstance() {
        if (instance != null) return instance;
        instance = new FormAddView();
        instance.setScene(new Scene(instance.getController().getAnchorPane()));
        instance.setStageForm(new Stage());
        instance.getStageForm().setScene(instance.getScene());
        instance.getStageForm().setResizable(false);
        return instance;
    }

    public void show(boolean isShow) {
        if (isShow) {
            if (stageForm.isShowing()) {
                stageForm.toFront();
            }
            else stageForm.show();
        }
        else {
            stageForm.close();
        }
    }
}
