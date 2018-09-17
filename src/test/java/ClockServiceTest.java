import tasks.employer.beans.Clock;
import org.junit.Before;
import org.junit.Test;
import tasks.employer.service.ClockService;

import java.io.UnsupportedEncodingException;

import static junit.framework.Assert.assertEquals;
import static tasks.employer.service.ClockService.*;

public class ClockServiceTest {

    private ClockService service;

    @Before
    public void init() {
        service = new ClockService();
    }

    @Test
    public void calcAngle() throws UnsupportedEncodingException {
        double result = 0;
        Clock clock = new Clock();

        for (int hour = 0; hour < 24; hour++) {
            clock.setHour(hour);
            for (int minute = 0; minute < 59; minute++) {
                clock.setMinute(minute);

                result = Math.abs((service.convertHoursToFormat12(hour) * ONE_HOUR_ANGLE) +
                        (minute * ONE_HOUR_FOLLOW_MINUTE_ANGLE) -
                        (minute * ONE_MINUTE_ANGLE));

                result = result > STRAIGHT_ANGLE ? MAX_ANGLE - result : result;

                assertEquals(result, service.calcAngle(clock));
            }
        }
    }

    @Test
    public void isValidateHours() {

        assertEquals(false, service.isValidateHours(24));
        assertEquals(false, service.isValidateHours(-5));
        assertEquals(true, service.isValidateHours(0));
        assertEquals(true, service.isValidateHours(10));
        assertEquals(false, service.isValidateHours(450));

    }
}
