package utils;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
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

    private TextArea getNodeFromGridPane_new(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                node = new TextArea();
                return (TextArea) node;
            }
        }
        return null;
    }

    public static Thu convertStringToThu(String thu) {
        switch (thu) {
            case "Thứ hai": return Thu.Mon;
            case "Thứ ba": return Thu.Tue;
            case "Thứ tư": return Thu.Wed;
            case "Thứ năm": return Thu.Thu;
            case "Thứ sáu": return Thu.Fri;
            case "Thứ bảy": return Thu.Sat;
            case "Chủ nhật": return Thu.Sun;
            default: return null;
        }
    }

    public static String convertThuToString(Thu thu) {
        switch (thu) {
            case Mon: return "Thứ hai";
            case Tue: return "Thứ ba";
            case Wed: return "Thứ tư";
            case Thu: return "Thứ năm";
            case Fri: return "Thứ sáu";
            case Sat: return "Thứ bảy";
            default: return "Chủ nhật";
        }
    }

}
