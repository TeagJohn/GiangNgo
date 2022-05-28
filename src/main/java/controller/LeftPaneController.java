package controller;

import View.FormAddView;
import View.LeftPaneView;
import View.SubjectView;
import View.TableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LeftPaneController implements Initializable {

    private static LeftPaneController controller;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ListView listView;
    @FXML
    private Label lbListSubject;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        listView.getItems().add(SubjectController.getInstance().getAnchorPane());
//        for (Subject subject : TimeTable.getInstance().getSubjectList()) {
//            addSubject(subject);
//        }
        for (Subject subject : TimeTable.getInstance().getSubjectList()) {
            addSubject(subject);
//            TableView.getController().add(subject);
        }
    }

    public ListView<SubjectView> getListView() {
        return listView;
    }

    public void setListView(ListView<SubjectView> listView) {
        this.listView = listView;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static LeftPaneController getInstance() {
        if (controller != null) return controller;
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/left_pane.fxml"));
        try {
            loader.load();
            controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    public void addSubject() {
        System.out.println("add");
        FormAddView formAddView = FormAddView.getInstance();
        formAddView.show(true);
    }

    public void addSubject(Subject subject) {
        SubjectView subjectView = new SubjectView(subject);
        listView.getItems().add(subjectView.view());
//        listView.setItems(listView.getItems());
        listView.refresh();
    }

    public void removeSubjectView(SubjectView subjectView) {
        listView.getItems().remove(subjectView.getController().getAnchorPane());

    }
}
