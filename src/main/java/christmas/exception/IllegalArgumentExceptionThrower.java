package christmas.exception;

import static christmas.config.CommonMessage.ERROR_SUFFIX;

public class IllegalArgumentExceptionThrower {
    public static void throwException(String message) {
        throw new IllegalArgumentException("%s %s".formatted(ERROR_SUFFIX.getMessage(), message));
    }
}