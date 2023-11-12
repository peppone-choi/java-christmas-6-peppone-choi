package christmas.model;

import static christmas.config.CommonConfigList.SPECIAL_DAY;
import static christmas.config.CommonConfigList.WEEKDAY;
import static christmas.config.CommonConfigList.WEEKEND;
import static christmas.config.CommonConfigNumber.CHRIST_MAS_D_DAY_EVENT_COST;
import static christmas.config.CommonConfigNumber.CHRIST_MAS_D_DAY_START_COST;
import static christmas.config.CommonConfigNumber.DATE_CHRISTMAS;
import static christmas.config.CommonConfigNumber.EVENT_DISCOUNT_COST;
import static christmas.config.CommonConfigNumber.GIFT_GIVEN_MONEY;
import static christmas.config.CommonConfigNumber.SPECIAL_DISCOUNT_COST;
import static christmas.config.CommonConfigNumber.THIS_MONTH;
import static christmas.config.CommonConfigNumber.THIS_YEAR;
import static christmas.config.CommonConfigNumber.ZERO;
import static christmas.model.DiscountAndGift.CHRISTMAS_D_DAY_DISCOUNT;
import static christmas.model.DiscountAndGift.GIFT_EVENT;
import static christmas.model.DiscountAndGift.SPECIAL_DISCOUNT;
import static christmas.model.DiscountAndGift.WEEKDAY_DISCOUNT;
import static christmas.model.DiscountAndGift.WEEKEND_DISCOUNT;

import christmas.dto.OrderDto;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Benefits {
    private final BenefitList benefits;

    public Benefits(List<OrderDto> orderDtoList, ExpectedVisitDate expectedVisitDate) {
        this.benefits = new BenefitList(makeBenefitList(orderDtoList, expectedVisitDate));
    }

    private static void addList(List<Benefit> benefits, int weekdayDiscount, int weekendDiscount, int specialDiscount,
                                int christmasDDayDiscount, int giftEvent) {
        benefits.add(new Benefit(WEEKDAY_DISCOUNT, weekdayDiscount));
        benefits.add(new Benefit(WEEKEND_DISCOUNT, weekendDiscount));
        benefits.add(new Benefit(SPECIAL_DISCOUNT, specialDiscount));
        benefits.add(new Benefit(CHRISTMAS_D_DAY_DISCOUNT, christmasDDayDiscount));
        benefits.add(new Benefit(GIFT_EVENT, giftEvent));
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
        if (WEEKDAY.getList().contains(getDayOfWeek(expectedVisitDate))) {
            return calculateDiscountForMenuDivision(orderDtoList, MenuDivision.DESSERT);
        }
        return ZERO.getNumber();
    }

    private int calculateWeekendDiscount(List<OrderDto> orderDtoList, int expectedVisitDate) {
        if (WEEKEND.getList().contains(getDayOfWeek(expectedVisitDate))) {
            return calculateDiscountForMenuDivision(orderDtoList, MenuDivision.MAIN);
        }
        return ZERO.getNumber();
    }

    private int calculateSpecialDiscount(int expectedVisitDate) {
        if (SPECIAL_DAY.getList().contains(expectedVisitDate)) {
            return SPECIAL_DISCOUNT_COST.getNumber();
        }
        return ZERO.getNumber();
    }

    private int calculateChristmasDDayDiscount(int expectedVisitDate) {
        int beforeChistmas = expectedVisitDate - DATE_CHRISTMAS.getNumber();
        if (beforeChistmas < 0) {
            return CHRIST_MAS_D_DAY_START_COST.getNumber() + (
                    (DATE_CHRISTMAS.getNumber() - Math.abs(beforeChistmas) - 1)
                            * CHRIST_MAS_D_DAY_EVENT_COST.getNumber());
        }
        return ZERO.getNumber();
    }

    private int calculateGiftEvent(List<OrderDto> orderDtoList) {
        int orderSum = orderDtoList.stream().mapToInt(OrderDto::calculateTotalCost).sum();
        if (orderSum >= GIFT_GIVEN_MONEY.getNumber()) {
            return Menu.CHAMPAGNE.getCost();
        }
        return ZERO.getNumber();
    }

    private DayOfWeek getDayOfWeek(int expectedVisitDate) {
        LocalDate date = LocalDate.of(THIS_YEAR.getNumber(), THIS_MONTH.getNumber(), expectedVisitDate);
        return date.getDayOfWeek();
    }

    private int calculateDiscountForMenuDivision(List<OrderDto> orderDtoList, MenuDivision menuDivision) {
        return orderDtoList
                .stream()
                .filter(orderDto -> orderDto.orderedMenu().getMenuDivision().equals(menuDivision))
                .mapToInt(orderDto -> orderDto.orderedCount() * EVENT_DISCOUNT_COST.getNumber())
                .sum();
    }

    public BenefitList getBenefits() {
        return benefits;
    }
}
