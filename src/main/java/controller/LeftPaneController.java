package controller;

import View.FormAddView;
import View.SubjectView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
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

    public static LeftPaneController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/left_pane.fxml"));
        try {
            loader.load();
            LeftPaneController controller = loader.getController();

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
}
