package christmas.exception;

import static christmas.config.CommonConfig.ERROR_SUFFIX;
import static christmas.config.CommonConfig.EXCEPTION_MESSAGE_FORMAT;

public class IllegalArgumentExceptionThrower {
    public static void throwException(String message) {
        throw new IllegalArgumentException(EXCEPTION_MESSAGE_FORMAT.getString()
                        .formatted(ERROR_SUFFIX.getString(), message));
    }
}
