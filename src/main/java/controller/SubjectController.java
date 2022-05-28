package controller;

import View.SubjectView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Subject;
import model.TimeTable;
import utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class SubjectController implements Initializable {
    private static SubjectController controller;
    private SubjectView view;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text sbname;
    @FXML
    private Text sbperiod;
    @FXML
    private Button remove;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public SubjectView getView() {
        return view;
    }

    public void setView(SubjectView view) {
        this.view = view;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static SubjectController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/subject.fxml"));
        try {
            loader.load();
            SubjectController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setSubject(Subject subject) {
        sbname.setText(subject.getName());
        sbperiod.setText(String.valueOf(subject.getNumberOfPer()));
    }
    @FXML
    public void removeSubject() {
        System.out.println("delete");
        Subject subject = view.getSubject();
        LeftPaneController leftPaneController = LeftPaneController.getInstance();
        TimeTable.getInstance().removeSubject(subject);

//        TimeTable.getInstance().remove
        Utils.showAlert("Xóa Môn học", "Xóa môn học thành công!");
    }

}
