package controller;

import View.LeftPaneView;
import View.TableView;
import dal.SubjectDAL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.*;
import utils.Utils;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class FormAddController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btAdd;
    @FXML
    private TextField tjSBid;
    @FXML
    private TextField tfSBid;
    @FXML
    private TextField tfSBname;
    @FXML
    private TextField tfPeriod;
    @FXML
    private TextField tfGVid;
    @FXML
    private TextField tfGVname;
    @FXML
    private TextField tfStart;
    @FXML
    private TextField tfEnd;
    @FXML
    private ChoiceBox cbThu;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clear();
    }
    public static FormAddController getInstance() {
        FXMLLoader loader = new FXMLLoader(Object.class.getResource("/formAdd.fxml"));
        try {
            loader.load();
            FormAddController controller = loader.getController();

            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    @FXML
    public void add() {
        String sbname = tfSBname.getText();
        String sbid = tfSBid.getText();
        String period = tfPeriod.getText();
        String gvid = tfGVid.getText();
        String gvname = tfGVname.getText();
        String timeStart = tfStart.getText();
        String timeEnd = tfEnd.getText();
        String thu = cbThu.getValue().toString();


        Teacher teacher1 = new Teacher(gvid, gvname);
        Time time = new Time(Integer.valueOf(timeStart), Integer.valueOf(timeEnd), Utils.convertStringToThu(thu));
//        Subject subject = new Subject(sbid, sbname, Integer.valueOf(period), teacher1, Arrays.asList(new Time(new Random().nextInt(), 3, Thu.Mon)));
        Subject subject = new Subject(sbid, sbname, Integer.valueOf(period)
                , teacher1, time);
        System.out.println(subject);
        try {
            TimeTable.getInstance().addSubject(subject);
        }catch (Exception e) {
            e.printStackTrace();
        }

//        TableView.getController().add(subject);


        Utils.showAlert("Add Subject", "Add subject successfully!");
        clear();
    }


    public void clear() {
        tfSBid.clear();
        tfSBname.clear();
        tfPeriod.clear();
        tfGVid.clear();
        tfGVname.clear();
        tfStart.clear();
        tfEnd.clear();
    }


}
