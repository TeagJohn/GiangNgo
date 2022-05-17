package controller;

import View.SubjectView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ListSubjectController implements Initializable {

    private static ListSubjectController controller;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getItems().add(SubjectController.getInstance().getAnchorPane());
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
