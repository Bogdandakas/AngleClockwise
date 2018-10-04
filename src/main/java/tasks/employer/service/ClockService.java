package tasks.employer.service;

import tasks.employer.entity.Clock;

public interface ClockService {

    int convertHoursToFormat12(int hour);

    String getAngle(Clock clock);

    double getHourAngle(Clock clock);

    double getMinuteAngle(Clock clock);

    String getTime(Clock clock);

    Clock getCurrentTime();

    Clock getRandomTime();

    Clock getNextTime(int hour, int minute);

}
