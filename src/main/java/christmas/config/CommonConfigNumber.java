package christmas.config;

public enum CommonConfigNumber {
    ZERO(0),
    GIFT_GIVEN_MONEY(120000),
    THIS_YEAR(2023),
    THIS_MONTH(12),
    DATE_CHRISTMAS(25),
    GIFT_GIVEN_COUNT(1),
    SPECIAL_DISCOUNT_COST(1000),
    EVENT_DISCOUNT_COST(2023),
    CHRIST_MAS_D_DAY_START_COST(1000),
    CHRIST_MAS_D_DAY_EVENT_COST(100);
    private final int number;

    CommonConfigNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
