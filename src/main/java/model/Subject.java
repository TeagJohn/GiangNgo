package model;

import View.SubjectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subject {

    private String id;
    private String name;
    private int numberOfPer;

    private Teacher teacher;
    private List<Time> timeList;
    private Time time;
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

    public Subject(String id, String name, int numberOfPer, Teacher teacher, Time time) {
        this.id = id;
        this.name = name;
        this.numberOfPer = numberOfPer;
        this.teacher = teacher;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public boolean isConflict(Subject s) {
//        for (Time t1 : timeList) {
//            for (Time t2 : s.getTimeList()) {
//                if (t1.isConflict(t2)) return true;
//            }
//        }
//        return false;

        return time.isConflict(s.getTime());
    }

    public int getColInTable() {
        Thu thu = time.getThu();
        switch (thu) {
            case Mon: return 1;
            case Tue: return 2;
            case Wed: return 3;
            case Thu: return 4;
            case Fri: return 5;
            case Sat: return 6;
            default: return 7;
        }
    }

    public List<Integer> getRowInTable() {
        List<Integer> rows = new ArrayList<>();
        for (int i = getTime().getStartPeriod(); i <= getTime().getEndPeriod(); i++) {
            rows.add(i);
        }
        return rows;
    }

    public String getInfo() {
        return id + " - " + name + "\n" +
                numberOfPer + " Tín chỉ" + "\n" +
                teacher.getName();
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfPer=" + numberOfPer +
                ", teacher=" + teacher +
                ", time=" + time +
                ", view=" + view +
                '}';
    }

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("GV1", "Teag John");
        Subject subject = new Subject("Toan", "T01", 3, teacher1, Arrays.asList(new Time(1, 3, Thu.Mon)));
        System.out.println(subject);
    }

}
