package controller;

import View.SubjectView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private static HomeController controller;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private SplitPane splitPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLeftPane(SubjectView.getController().getAnchorPane());
    }

    public static HomeController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/home.fxml"));
        try {
            loader.load();
            HomeController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public AnchorPane getLeftPane() {
        return leftPane;
    }

    public void setLeftPane(AnchorPane leftPane) {
        this.leftPane = leftPane;
        splitPane.getItems().set(0, leftPane);
    }

    public AnchorPane getRightPane() {
        return rightPane;
    }

    public void setRightPane(AnchorPane rightPane) {
        this.rightPane = rightPane;
        splitPane.getItems().set(1, rightPane);
    }
}
