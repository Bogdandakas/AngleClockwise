package tasks.employer.beans;

public class Clock {

    private static final String ZERO = "0";
    private static final String EMPTY = "";
    private static final String SEPARATOR = ":";
    private static final int NUMBER = 10;

    private int hour;
    private int minute;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getTime() {
        String minute = this.minute < NUMBER ? ZERO + this.minute : EMPTY + this.minute;
        return hour + SEPARATOR + minute;
    }
}
