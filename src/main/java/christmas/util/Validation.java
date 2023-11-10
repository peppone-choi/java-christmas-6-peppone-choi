package christmas.util;

import static christmas.config.ValidConfig.DATE_MAX;
import static christmas.config.ValidConfig.DATE_MIN;
import static christmas.config.ValidMessage.DATE_VALID_ERROR;

import christmas.exception.IllegalArgumentExceptionThrower;

public class Validation {
    public static void dateValid(String date) {
        dateIntegerValid(date);
        dateRangeValid(Integer.parseInt(date));
    }

    private static void dateIntegerValid(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throwException(DATE_VALID_ERROR.getMessage());
        }
    }

    private static void dateRangeValid(int date) {
        if (date < DATE_MIN.getProperty() || date > DATE_MAX.getProperty()) {
            throwException(DATE_VALID_ERROR.getMessage());
        }
    }

    private static void throwException(String message) {
        IllegalArgumentExceptionThrower
                .throwException(message);
    }
}
