package christmas.model;

import christmas.util.Validation;

public class ExpectedVisitDate {
    private final Date date;

    public ExpectedVisitDate(int date) {
        Validation.validDate(String.valueOf(date));
        this.date = new Date(date);
    }

    public Date getDate() {
        return date;
    }
}
