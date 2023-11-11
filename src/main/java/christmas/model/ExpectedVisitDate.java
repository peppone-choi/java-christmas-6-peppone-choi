package christmas.model;

import christmas.util.Validation;

public class ExpectedVisitDate {
    private final int date;

    public ExpectedVisitDate(int date) {
        Validation.validDate(String.valueOf(date));
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
