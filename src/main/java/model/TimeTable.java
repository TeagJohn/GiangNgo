package model;

import View.SubjectView;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {

    private static TimeTable instance;

    private List<Subject> subjectList = new ArrayList<>();

    private TimeTable() {}

    public static TimeTable getInstance() {
        if (instance!= null) return instance;
        instance = new TimeTable();
        return instance;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addSubject(Subject subject) {
        boolean isConflict = false;
        for (Subject s : subjectList) {
            if (s.isConflict(subject)) {
                isConflict = true;
                break;
            }
        }
        if (isConflict = true) {
            Utils.showAlert("Add Subject", "Khong the them mon hoc do trung mon khac");
        }
        else {
            subjectList.add(subject);
            SubjectView view = new SubjectView(subject);

        }

    }
}
