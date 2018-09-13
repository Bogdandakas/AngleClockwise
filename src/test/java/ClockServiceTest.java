import beans.Clock;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import service.ClockService;

import static junit.framework.Assert.assertEquals;
import static service.ClockService.*;

public class ClockServiceTest {

    private ClockService service;

    @Before
    public void init() {
        service = new ClockService();
    }


//    @Test(expected = RuntimeException.class)
//    public void getInputnumber() {
//        App app = new App();
//
//    }

    @Test
    public void calcAngle() {
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
