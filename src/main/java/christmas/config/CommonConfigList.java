package christmas.config;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.util.List;

public enum CommonConfigList {
    WEEKDAY(List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, SUNDAY)),
    WEEKEND(List.of(FRIDAY, SATURDAY)),
    SPECIAL_DAY(List.of(3, 10, 17, 24, 25, 31));
    private final List<Object> list;

    CommonConfigList(List<Object> list) {
        this.list = list;
    }

    public List<Object> getList() {
        return list;
    }
}
