package christmas.model;

import static christmas.config.CommonConfigNumber.DATE_CHRISTMAS;
import static christmas.config.CommonConfigNumber.GIFT_GIVEN_MONEY;
import static christmas.model.DiscountAndGift.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.model.DiscountAndGift.GIFT_EVENT;
import static christmas.model.DiscountAndGift.SPECIAL_DISCOUNT;
import static christmas.model.DiscountAndGift.WEEKDAY_DISCOUNT;
import static christmas.model.DiscountAndGift.WEEKEND_DISCOUNT;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.dto.OrderDto;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    public Benefits(List<OrderDto> orderDtoList, ExpectedVisitDate expectedVisitDate) {
        this.benefits = makeBenefitList(orderDtoList, expectedVisitDate);
    }

    private static void addList(List<Benefit> benefits, int weekdayDiscount, int weekendDiscount, int specialDiscount,
                                int christmasDDayDiscount, int giftEvent) {
        benefits.add(new Benefit(WEEKDAY_DISCOUNT, weekdayDiscount));
        benefits.add(new Benefit(WEEKEND_DISCOUNT, weekendDiscount));
        benefits.add(new Benefit(SPECIAL_DISCOUNT, specialDiscount));
        benefits.add(new Benefit(CHRISTMAS_D_DAY_DISCOUNT, christmasDDayDiscount));
        benefits.add(new Benefit(GIFT_EVENT, giftEvent));
    }

    public String printBenefits() {
        int sum = benefits.stream().mapToInt(Benefit::getBenefitAmount).sum();
        if (sum <= 0) {
            return "없음\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        benefits.forEach(benefit -> stringBuilder.append(benefit.printBenefit()));
        return stringBuilder.toString();
    }

    public int sumBenefits() {
        return benefits.stream()
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }

    public int sumDiscount() {
        return benefits.stream()
                .filter(benefit -> !benefit.getDiscountAndGift().equals(GIFT_EVENT))
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }

    private List<Benefit> makeBenefitList(List<OrderDto> orderDtoList, ExpectedVisitDate expectedVisitDate) {
        List<Benefit> benefits = new ArrayList<>();

        int weekdayDiscount = calculateWeekdayDiscount(orderDtoList, expectedVisitDate.getDate());
        int weekendDiscount = calculateWeekendDiscount(orderDtoList, expectedVisitDate.getDate());
        int specialDiscount = calculateSpecialDiscount(expectedVisitDate.getDate());
        int christmasDDayDiscount = calculateChristmasDDayDiscount(expectedVisitDate.getDate());
        int giftEvent = calculateGiftEvent(orderDtoList);

        addList(benefits, weekdayDiscount, weekendDiscount, specialDiscount, christmasDDayDiscount, giftEvent);

        return benefits;
    }

    private int calculateWeekdayDiscount(List<OrderDto> orderDtoList, int expectedVisitDate) {
        if (List.of(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, SUNDAY).contains(getDayOfWeek(expectedVisitDate))) {
            return calculateDiscountForMenuDivision(orderDtoList, MenuDivision.DESSERT);
        }
        return 0;
    }

    private int calculateWeekendDiscount(List<OrderDto> orderDtoList, int expectedVisitDate) {
        if (List.of(FRIDAY, SATURDAY).contains(getDayOfWeek(expectedVisitDate))) {
            return calculateDiscountForMenuDivision(orderDtoList, MenuDivision.MAIN);
        }
        return 0;
    }

    private int calculateSpecialDiscount(int expectedVisitDate) {
        if (List.of(3, 10, 17, 24, 25, 31).contains(expectedVisitDate)) {
            return 1000;
        }
        return 0;
    }

    private int calculateChristmasDDayDiscount(int expectedVisitDate) {
        int beforeChistmas = expectedVisitDate - DATE_CHRISTMAS.getNumber();
        if (beforeChistmas < 0) {
            return 1000 + ((DATE_CHRISTMAS.getNumber() - Math.abs(beforeChistmas) - 1) * 100);
        }
        return 0;
    }

    private int calculateGiftEvent(List<OrderDto> orderDtoList) {
        int orderSum = orderDtoList.stream().mapToInt(OrderDto::calculateTotalCost).sum();
        return (orderSum >= GIFT_GIVEN_MONEY.getNumber()) ? Menu.CHAMPAGNE.getCost() : 0;
    }

    private DayOfWeek getDayOfWeek(int expectedVisitDate) {
        LocalDate date = LocalDate.of(2023, 12, expectedVisitDate);
        return date.getDayOfWeek();
    }

    private int calculateDiscountForMenuDivision(List<OrderDto> orderDtoList, MenuDivision menuDivision) {
        return orderDtoList
                .stream()
                .filter(orderDto -> orderDto.orderedMenu().getMenuDivision().equals(menuDivision))
                .mapToInt(orderDto -> orderDto.orderedCount() * 2023)
                .sum();
    }
}
