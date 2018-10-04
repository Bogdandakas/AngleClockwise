package tasks.employer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.log.LogHandler;
import tasks.employer.entity.Clock;
import tasks.employer.entity.Log;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static tasks.employer.entity.Log.*;

@Service
public class ClockServiceImpl implements ClockService {

    private static final int DAY_HOURS = 24;
    private static final int HOUR_MINUTES = 60;
    public static final int HALF_DAY_HOURS = 12;
    public static final double ONE_HOUR_FOLLOW_MINUTE_ANGLE = 0.5;
    public static final int ONE_HOUR_ANGLE = 30;
    public static final int ONE_MINUTE_ANGLE = 6;
    public static final int STRAIGHT_ANGLE = 180;
    public static final int MAX_ANGLE = 360;
    private static final String ZERO = "\u0030";
    private static final String COLON = "\u003A";
    private static final int NUMBER = 10;

    private static Logger logger = Logger.getLogger(LogHandler.class.getName());

    @Autowired
    private PropertiesServiceImpl properties;

    @Autowired
    private LogDBServiceImpl logDBService;

    @Override
    public int convertHoursToFormat12(int hour) {
        return hour > HALF_DAY_HOURS ? hour - HALF_DAY_HOURS : hour;
    }

    @Override
    public String getAngle(Clock clock) {

        String result;

        double angle = Math.abs(getHourAngle(clock) - getMinuteAngle(clock));
        angle = angle > STRAIGHT_ANGLE ? MAX_ANGLE - angle : angle;

        result = properties.get(INPUT) + getTime(clock) + properties.get(ANGLE) + angle + properties.get(DEGREE_SYMBOL);
        logger.log(Level.INFO, result);
        logDBService.save(new Log(Level.INFO.toString(), result, new Date()));

        return result;
    }

    @Override
    public double getHourAngle(Clock clock) {
        return convertHoursToFormat12(clock.getHour()) * ONE_HOUR_ANGLE + clock.getMinute() * ONE_HOUR_FOLLOW_MINUTE_ANGLE;
    }

    @Override
    public double getMinuteAngle(Clock clock) {
        return clock.getMinute() * ONE_MINUTE_ANGLE;
    }

    @Override
    public String getTime(Clock clock) {
        String minute = clock.getMinute() < NUMBER ? ZERO + clock.getMinute() : String.valueOf(clock.getMinute());
        return clock.getHour() + COLON + minute;
    }

    @Override
    public Clock getCurrentTime() {
        Date date = new Date();
        return new Clock(date.getHours(), date.getMinutes());
    }

    @Override
    public Clock getRandomTime() {
        return new Clock(new Random().nextInt(23), new Random().nextInt(59));
    }

    @Override
    public Clock getNextTime(int hour, int minute) {

        if (minute == HOUR_MINUTES) {
            minute = Integer.valueOf(ZERO);
            hour++;
        }
        if (hour == DAY_HOURS) {
            hour = Integer.valueOf(ZERO);
        }
        return new Clock(hour, minute);
    }
}


