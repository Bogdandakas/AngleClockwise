package service;

import beans.Clock;
import sun.rmi.log.LogHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

import static beans.LogMessage.DEGREE_SYMBOL;
import static beans.LogMessage.INPUT_TIME;
import static beans.LogMessage.RESULT;

public class ClockService {

    private static final int DAY_HOURS = 24;
    private static final int HOUR_MINUTES = 60;
    public static final int HALF_DAY_HOURS = 12;
    public static final double ONE_HOUR_FOLLOW_MINUTE_ANGLE = 0.5;
    public static final int ONE_HOUR_ANGLE = 30;
    public static final int ONE_MINUTE_ANGLE = 6;
    public static final int STRAIGHT_ANGLE = 180;
    public static final int MAX_ANGLE = 360;

    private static Logger logger = Logger.getLogger(LogHandler.class.getName());

    public int convertHoursToFormat12(int hour) {

        return hour > HALF_DAY_HOURS ? hour - HALF_DAY_HOURS : hour;
    }

    public boolean isValidateHours(int hour) {

        return hour >= 0 && hour < DAY_HOURS;
    }

    public boolean isValidateMinutes(int minute) {

        return minute >= 0 && minute < HOUR_MINUTES;
    }

    public double calcAngle(Clock clock) {

        double hourDegree = convertHoursToFormat12(clock.getHour()) * ONE_HOUR_ANGLE + clock.getMinute() * ONE_HOUR_FOLLOW_MINUTE_ANGLE;
        double minuteDegree = clock.getMinute() * ONE_MINUTE_ANGLE;
        double result = Math.abs(hourDegree - minuteDegree);

        result = result > STRAIGHT_ANGLE ? MAX_ANGLE - result : result;
        logger.log(Level.INFO, INPUT_TIME + clock.getTime() + RESULT + result + DEGREE_SYMBOL);

        return result;
    }
}
