package dal;

import model.Subject;
import model.Teacher;
import model.Time;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAL {
    private final String TEACHER_ID = "teacher_id";
    private final String TEACHER_NAME = "teacher_name";

    private String query;
    private ResultSet setResult;

    public Teacher getTeacherById(int sid) throws SQLException {
        //todo: add query here
        query = "";

        //todo: connect DB
        DBHelper.getConnection();
        setResult = DBHelper.executeQuery(query);

        Subject subject = null;

        DBHelper.closeConnection();
        //todo: code here
        return null;
    }

    private Teacher getTeacherInfo(ResultSet set) throws SQLException {
//        String id = String.valueOf(set.getInt(S_ID));
//        String name = String.valueOf(set.getString(S_NAME));;
//        int num_per = set.getInt(S_NUM_PERIOD);
//        int teacher_id = set.getInt(S_TEACHER_ID);
//        Teacher teacher;
//
//        int time_id = set.getInt(S_TIME_ID);
//        List<Time> list = new ArrayList<>();
//        Subject subject = new Subject(id, name, num_per, teacher, list);
        return null;
    }
}
