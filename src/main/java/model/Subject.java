package model;

import View.SubjectView;

import java.util.Arrays;
import java.util.List;

public class Subject {

    private String id;
    private String name;
    private int numberOfPer;

    private SubjectView view;

    public SubjectView getView() {
        return view;
    }

    public void setView(SubjectView view) {
        this.view = view;
    }

    public int getNumberOfPer() {
        return numberOfPer;
    }

    public void setNumberOfPer(int numberOfPer) {
        this.numberOfPer = numberOfPer;
    }

    public Subject(String id, String name, int numberOfPer, Teacher teacher, List<Time> timeList) {
        this.id = id;
        this.name = name;
        this.numberOfPer = numberOfPer;
        this.teacher = teacher;
        this.timeList = timeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    private Teacher teacher;
    private List<Time> timeList;

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPer=" + numberOfPer +
                ", teacher=" + teacher +
                ", timeList=" + timeList +
                '}';
    }

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("GV1", "Teag John");
        Subject subject = new Subject("Toan", "T01", 3, teacher1, Arrays.asList(new Time(1, 3, Thu.Mon)));
        System.out.println(subject);
    }

}
