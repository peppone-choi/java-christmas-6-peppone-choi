package christmas.config;

public enum OrderConfig {
    ORDER_PRINT_FORMAT("{0} {1}개");
    private final String string;

    OrderConfig(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
