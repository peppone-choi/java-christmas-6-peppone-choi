package christmas.config;

public enum CommonMessage {
    ERROR_SUFFIX("[ERROR]");
    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
