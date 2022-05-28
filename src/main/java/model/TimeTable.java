package model;

import View.LeftPaneView;
import View.SubjectView;
import View.TableView;
import controller.LeftPaneController;
import controller.TableController;
import dal.SubjectDAL;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {

    private static TimeTable instance;

    private List<Subject> subjectList = new ArrayList<>();

    private TimeTable() {
//        readDatabase();
//        update();
    }

    public static TimeTable getInstance() {
        if (instance!= null) return instance;
        instance = new TimeTable();
        instance.update();
        return instance;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public boolean addSubjectToTimeTableOnly(Subject subject) {
        boolean isConflict = false;
        for (Subject s : subjectList) {
            if (s.isConflict(subject)) {
                isConflict = true;
                break;
            }
        }
        if (isConflict == true) {
            Utils.showAlert("Add Subject", "Khong the them mon hoc do trung mon khac");
        }
        else {
            subjectList.add(subject);
            SubjectView view = new SubjectView(subject);
            return true;
        }
        return false;
    }

    public void readDatabase() {
        try {
            subjectList = new SubjectDAL().getAllSubjectFromDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimeTable timeTable = TimeTable.getInstance();
        timeTable.readDatabase();
        System.out.println(timeTable.getSubjectList().size());
        for (Subject s : timeTable.getSubjectList()) {
            System.out.println(s);
        }
    }

    public void removeSubject(Subject subject) {
        if (subjectList.contains(subject)) {
            subjectList.remove(subject);
            new SubjectDAL().removeSubjectInDatabase(subject);
            LeftPaneController.getInstance().removeSubjectView(subject.getView());
            TableController.getInstance().removeSubject(subject);
        }
    }
    public void addSubject(Subject subject) {
        boolean isSuccess = addSubjectToTimeTableOnly(subject);
        if (isSuccess) {
            try {
                new SubjectDAL().addSubjectToDatabase(subject);
            } catch (Exception e) {
//                e.printStackTrace();
            }
            LeftPaneView.getController().addSubject(subject);
            TableView.getController().add(subject);
        }
    }

    public void update() {
        subjectList = new ArrayList<>();
        readDatabase();
        for (Subject subject : subjectList) {
            LeftPaneView.getController().addSubject(subject);
            TableView.getController().add(subject);
        }
    }
}
