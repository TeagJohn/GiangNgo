package utils;

import javafx.scene.control.Alert;

public class Utils {
    public static  void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
