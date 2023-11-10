package christmas.config;

public enum ValidMessage {
    DATE_VALID_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private final String message;

    ValidMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
