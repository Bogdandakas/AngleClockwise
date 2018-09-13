import beans.Clock;
import service.ClockService;
import sun.rmi.log.LogHandler;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static beans.LogMessage.*;

public class App {

    private static final int EXIT = 0;
    private static boolean isOn = true;

    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(LogHandler.class.getName());

    public static void main(String args[]) {

        onApp();
    }

    private static void onApp() {

        logger.log(Level.INFO, START_MESSAGE);

        while (isOn) {

            runApp();
        }

        scanner.close();
        logger.log(Level.INFO, FINISH_MESSAGE);
    }

    private static void runApp() {

        ClockService service = new ClockService();

        Clock clock = new Clock();
        clock.setHour(getHoursFromScanner(service));
        clock.setMinute(getMinutesFromScanner(service));

        service.calcAngle(clock);

        isOn = getRunStatus();
    }

    private static boolean getRunStatus() {

        boolean runInput = true;
        while (runInput) {
            logger.log(Level.INFO, CONTINUE_CALCULATION);

            try {
                int input = scanner.nextInt();
                return input == EXIT;

            } catch (InputMismatchException e) {
                scanner.next();
                logger.log(Level.WARNING, NOT_VALID_INPUT);
            }
        }
        return false;
    }

    private static int getHoursFromScanner(ClockService service) {

        boolean runInput = true;
        while (runInput) {
            logger.log(Level.INFO, INPUT_HOURS);

            try {
                int hour = scanner.nextInt();
                if (service.isValidateHours(hour)) {
                    return hour;
                } else {
                    logger.log(Level.WARNING, NOT_VALID_HOURS);
                }

            } catch (InputMismatchException e) {
                scanner.next();
                logger.log(Level.WARNING, NOT_VALID_INPUT);
            }
        }
        return 0;
    }

    private static int getMinutesFromScanner(ClockService service) {

        boolean runInput = true;
        while (runInput) {
            logger.log(Level.INFO, INPUT_MINUTES);

            try {
                int minutes = scanner.nextInt();
                if (service.isValidateMinutes(minutes)) {
                    return minutes;
                } else {
                    logger.log(Level.WARNING, NOT_VALID_MINUTES);
                }

            } catch (InputMismatchException e) {
                scanner.next();
                logger.log(Level.WARNING, NOT_VALID_INPUT);
            }
        }
        return 0;
    }
}





