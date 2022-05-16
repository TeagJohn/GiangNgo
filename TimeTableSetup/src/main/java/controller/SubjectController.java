package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SubjectController implements Initializable {
    private static SubjectController controller;

    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static SubjectController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/subject.fxml"));
        try {
            loader.load();
            SubjectController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
