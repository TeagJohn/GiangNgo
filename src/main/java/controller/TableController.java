package controller;

import View.LeftPaneView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Subject;
import model.Thu;
import model.Time;
import model.TimeTable;
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
        for (Subject subject : TimeTable.getInstance().getSubjectList()) {
//            LeftPaneView.getController().addSubject(subject);
            add(subject);
        }
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
//        List<Time> timeList = subject.getTimeList();
//        for (Time time : timeList) {
//            int start = time.getStartPeriod();
//            int end = time.getEndPeriod();
//            Thu thu = time.getThu();
//            gridPane.getColumnConstraints().get(1);
//            Node node = Utils.getNodeFromGridPane(gridPane, getCol(thu), start);
//        }
        List<Integer> rows = subject.getRowInTable();
        int col = subject.getColInTable();

        for (int i : rows) {
            TextArea textArea = (TextArea) Utils.getNodeFromGridPane(gridPane, col, i);
            if (textArea == null) {
                textArea = new TextArea();
                textArea.setEditable(false);
                gridPane.add(textArea, col, i);
            }
            textArea.setText(subject.getInfo());
        }
    }

    public void removeSubject(Subject subject) {
        int col = subject.getColInTable();
        List<Integer> rows = subject.getRowInTable();
        for (int i : rows) {
            TextArea textArea = (TextArea) Utils.getNodeFromGridPane(gridPane, col, i);
            if (textArea != null) {
                textArea.clear();
            }
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
