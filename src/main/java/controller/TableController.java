package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Subject;
import model.Thu;
import model.Time;
import utils.Utils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    private static TableController controller;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane gridPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Text t = new Text("Hello");
//        gridPane.add(t, 1, 1, 1, 2);
//        GridPane.setHalignment(t, Pos.CENTER.getHpos());
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public static TableController getInstance() {
        if (controller != null) return controller;
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/table.fxml"));
        try {
            loader.load();
            controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Subject subject) {
        List<Time> timeList = subject.getTimeList();
        for (Time time : timeList) {
            int start = time.getStartPeriod();
            int end = time.getEndPeriod();
            Thu thu = time.getThu();
            gridPane.getColumnConstraints().get(1);
            Node node = Utils.getNodeFromGridPane(gridPane, getCol(thu), start);
        }
    }

    public int getCol(Thu thu) {
        switch (thu) {
            case Mon: return 1;
            case Tue: return 2;
            case Wed: return 3;
            case Thu: return 4;
            case Fri: return 5;
            case Sat: return 6;
            case Sun: return 7;

            default: return 0;
        }
    }

}
