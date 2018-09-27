package tasks.employer.service;

import tasks.employer.beans.Clock;

public interface ClockService {

    int convertHoursToFormat12(int hour);

    boolean isValidateHours(int hours);

    boolean isValidateMinutes(int minutes);

    double calcAngle(Clock clock);
}
