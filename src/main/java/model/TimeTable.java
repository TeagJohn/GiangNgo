package model;

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
}
