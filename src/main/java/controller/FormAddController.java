package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FormAddController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btAdd;
    @FXML
    private TextField tjSBid;
    @FXML
    private TextField tfSBid;
    @FXML
    private TextField tfSBname;
    @FXML
    private TextField tfPeriod;
    @FXML
    private TextField tfGVid;
    @FXML
    private TextField tfGVname;
    @FXML
    private TextField tfTime;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clear();
    }
    public static FormAddController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/formAdd.fxml"));
        try {
            loader.load();
            FormAddController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    @FXML
    public void add() {
        String sbname = tfSBname.getText();
        String sbid = tfSBid.getText();
        String period = tfPeriod.getText();
        String gvid = tfGVid.getText();
        String gvname = tfGVname.getText();

        showAlert("Add Subject", "Add subject successfully!");
        clear();
    }

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void clear() {
        tfSBid.clear();
        tfSBname.clear();
        tfPeriod.clear();
        tfGVid.clear();
        tfGVname.clear();
        tfTime.clear();
    }
}