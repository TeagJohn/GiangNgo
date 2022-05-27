package dal;

import model.Subject;
import model.Teacher;
import model.Time;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAL {

    //column
    private final String S_ID = "subject_id";
    private final String S_NAME = "subject_name";
    private final String S_NUM_PERIOD = "number_period";
    private final String S_TEACHER_ID = "teacher_id";
    private final String S_TIME_ID = "time_id";

    private String query;
    private ResultSet setResult;

    public Subject getSubjectById(int sid) throws SQLException {
        //todo: add query here
        query = "";

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
        String id = String.valueOf(set.getInt(S_ID));
        String name = String.valueOf(set.getString(S_NAME));;
        int num_per = set.getInt(S_NUM_PERIOD);
        int teacher_id = set.getInt(S_TEACHER_ID);
        Teacher teacher = new TeacherDAL().getTeacherById(teacher_id);

        int time_id = set.getInt(S_TIME_ID);
        List<Time> list = new TimeDAL().getTimesById(time_id);
        Subject subject = new Subject(id, name, num_per, teacher, list);
        return subject;
    }
}
