package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private static TableController controller;
    @FXML
    private GridPane gridPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Text t = new Text("Hello");
        gridPane.add(t, 1, 1, 1, 2);
        GridPane.setHalignment(t, Pos.CENTER.getHpos());
    }

    public static TableController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/home.fxml"));
        try {
            loader.load();
            TableController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
