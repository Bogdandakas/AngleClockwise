package tasks.employer.beans;

public class Clock {

    private static final String ZERO = "\u0030";
    private static final String EMPTY = "\u0000";
    private static final String COLON = "\u003A";
    private static final int NUMBER = 10;

    private int hour;
    private int minute;

    public Clock(){}

    public Clock(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

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
        return hour + COLON + minute;
    }
}
