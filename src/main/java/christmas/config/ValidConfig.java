package christmas.config;

public enum ValidConfig {
    DATE_MIN(1),
    DATE_MAX(31),
    DATE_CHRISTMAS(25);
    private final int property;

    ValidConfig(int property) {
        this.property = property;
    }

    public int getProperty() {
        return property;
    }
}
