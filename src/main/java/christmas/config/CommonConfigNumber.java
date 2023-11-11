package christmas.config;

public enum CommonConfigNumber {
    GIFT_GIVEN_MONEY(120000),
    DATE_CHRISTMAS(25),
    GIFT_GIVEN_COUNT(1);
    private final int number;

    CommonConfigNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
