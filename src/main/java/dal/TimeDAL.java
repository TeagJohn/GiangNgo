package dal;

import model.Subject;
import model.Teacher;
import model.Time;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAL {
    private final String TIME_ID = "time_id";
    private final String TIME_THU = "thu";
    private final String TIME_START = "start";

    private String query;
    private ResultSet setResult;

    public List<Time> getTimesById(int sid) throws SQLException {
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

    public List<Time> getListTime(ResultSet set) {
        List<Time> list = new ArrayList<>();

        return list;
    }

    private Time getTImeInfo(ResultSet set) throws SQLException {

        return null;
    }
}
