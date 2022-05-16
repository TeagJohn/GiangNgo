package controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ListSubjectController implements Initializable {

    private static ListSubjectController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public static ListSubjectController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/list_subject.fxml"));
        try {
            loader.load();
            ListSubjectController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
