package model;

public class Time {
    private int startPeriod;
    private int endPeriod;
    private Thu thu;

    public int getStartPeriod() {
        return startPeriod;
    }

    public Time(int startPeriod, int endPeriod, Thu thu) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.thu = thu;
    }

    public void setStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
    }

    @Override
    public String toString() {
        return "Time{" +
                "startPeriod=" + startPeriod +
                ", endPeriod=" + endPeriod +
                ", thu=" + thu +
                '}';
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Thu getThu() {
        return thu;
    }

    public void setThu(Thu thu) {
        this.thu = thu;
    }
}
