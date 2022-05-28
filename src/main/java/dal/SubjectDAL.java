package dal;

import model.*;
import utils.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubjectDAL {

    //column
    private final String S_ID = "subject_id";
    private final String S_NAME = "subject_name";
    private final String S_NUM_PERIOD = "number_period";
    private final String S_TEACHER_ID = "teacher_id";
    private final String S_TEACHER_NAME = "teacher_name";
    private final String S_TIME_ID = "time_id";
    private final String S_START_PERIOD = "start_period";
    private final String S_END_PERIOD = "end_period";

    private String query;
    private ResultSet setResult;

    public Subject getSubjectById(String sid) throws SQLException {
        //todo: add query here
        query = "SELECT * from subject where subject_id=\'" + sid + "\'";

        //todo: connect DB
        DBHelper.getConnection();
        setResult = DBHelper.executeQuery(query);

        Subject subject = null;
        while (setResult.next()) {
            subject = getSubjectInfo(setResult);
        }
        DBHelper.closeConnection();
        return subject;
    }

    private Subject getSubjectInfo(ResultSet set) throws SQLException {
        String id = set.getString(S_ID);
        String name = set.getString(S_NAME);
        int num_per = set.getInt(S_NUM_PERIOD);
        String teacher_id = set.getString(S_TEACHER_ID);
        String teacher_name = set.getString(S_TEACHER_NAME);
        String time_id = set.getString(S_TIME_ID);
        int start = set.getInt(S_START_PERIOD);
        int end = set.getInt(S_END_PERIOD);
        System.out.println(id + "-" + name + "-" + num_per + "-" + teacher_id + "-" + teacher_name + "-" + time_id + "-" + start);
        Teacher teacher = new Teacher(teacher_id, teacher_name);
        Time time = new Time(start, end, Utils.convertStringToThu(time_id));
        Subject subject = new Subject(id, name, num_per, teacher, time);


//        Subject subject = new Subject(id, name, num_per, teacher, list);
        return subject;
//        return null;
    }

    public void addSubjectToDatabase(Subject subject) throws SQLException {
        //INSERT INTO subject VALUES('MH01',N'Toán',3,'GV01',N'Nhung',N'monday',3,5)
        String sid = subject.getId();
        String sname = subject.getName();
        int num_per = subject.getNumberOfPer();
        String tid = subject.getTeacher().getId();
        String tname = subject.getTeacher().getName();
        int start = subject.getTime().getStartPeriod();
        int end = subject.getTime().getEndPeriod();
        String thu = Utils.convertThuToString(subject.getTime().getThu());

        query = "INSERT INTO subject VALUES(\'" + sid + "\',N\'" + sname + "\'," + num_per + ",\'" +
                tid + "\',N\'" + tname + "\',N\'" + thu + "\'," + start + "," + end + ")";
        query = " insert into subject (" + S_ID + ","+S_NAME+","+S_NUM_PERIOD+","+S_TEACHER_ID+","+S_TEACHER_NAME+","
                +S_TIME_ID+","+S_START_PERIOD+","+S_END_PERIOD+ ")"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        DBHelper.getConnection();
        DBHelper.executeQuerySubject(query, Arrays.asList(sid, sname, num_per, tid, tname, thu, start, end));

        DBHelper.closeConnection();
    }

    public List<Subject> getAllSubjectFromDatabase() throws SQLException {
        //todo: add query here
        query = "SELECT * from subject";
        List<Subject> subjectList = new ArrayList<>();

        //todo: connect DB
        DBHelper.getConnection();
        setResult = DBHelper.executeQuery(query);

        while (setResult.next()) {
            Subject subject = null;
            subject = getSubjectInfo(setResult);
            subjectList.add(subject);
        }
        DBHelper.closeConnection();
        return subjectList;
    }

    public void removeSubjectInDatabase(Subject subject) {
        //DELETE FROM subject where subject_id='a1'
        query = "DELETE FROM subject where " + S_ID + "=\'" + subject.getId() + "\'";
        try {
            //todo: connect DB
            DBHelper.getConnection();
            setResult = DBHelper.executeQuery(query);
//            DBHelper.executeQuery(query);
            DBHelper.closeConnection();
        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
//        Subject subject = new Subject("T1000", "Toans", 3
//                , new Teacher("gv1", "Giang")
//                , new Time(2, 3, Thu.Mon) );
        Subject subject = TimeTable.getInstance().getSubjectList().get(0);
        new SubjectDAL().removeSubjectInDatabase(subject);
    }



}
