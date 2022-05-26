package utils;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import model.Thu;

public class Utils {
    public static  void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            Integer columnIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);

            if (columnIndex == null)
                columnIndex = 0;
            if (rowIndex == null)
                rowIndex = 0;

            if (columnIndex == col && rowIndex == row) {
                return node;
            }
        }
        return null;
    }

    public Thu convertStringToThu(String thu) {
        switch (thu) {
            case "Thứ 2": return Thu.Mon;
            case "Thứ 3": return Thu.Tue;
            case "Thứ 4": return Thu.Wed;
            case "Thứ 5": return Thu.Thu;
            case "Thứ 6": return Thu.Fri;
            case "Thứ 7": return Thu.Sat;
            case "Chủ nhật": return Thu.Sun;
            default: return null;

        }
    }
}
