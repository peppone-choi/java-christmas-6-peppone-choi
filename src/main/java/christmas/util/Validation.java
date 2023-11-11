package christmas.util;

import static christmas.config.CommonConfig.ORDERS_REGEX;
import static christmas.config.CommonConfig.ORDER_MENU_COUNT_REGEX;
import static christmas.config.ValidConfig.DATE_MAX;
import static christmas.config.ValidConfig.DATE_MIN;
import static christmas.config.ValidConfig.ORDER_COUNT_MAX;
import static christmas.config.ValidMessage.ALL_DRINK_ERROR;
import static christmas.config.ValidMessage.DATE_VALID_ERROR;
import static christmas.config.ValidMessage.MENU_ORDER_OVER_20_ERROR;
import static christmas.config.ValidMessage.ORDER_VALID_ERROR;
import static christmas.model.MenuDivision.DRINK;

import christmas.exception.IllegalArgumentExceptionThrower;
import christmas.model.Menu;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Validation {
    public static void validDate(String date) {
        dateIntegerValid(date);
        dateRangeValid(Integer.parseInt(date));
    }

    public static void validOrders(String order) {
        parseOrders(order);
        validateDrinkOrder(order);
        List<String> orders = List.of(order.split(ORDERS_REGEX.getString()));
        orders.forEach(Validation::validOrder);
        validOrderCount(orders);
        validateUniqueOrders(orders);
    }

    private static int getTotalPrice(List<String> order) {
        return order.stream()
                .map(orders -> orders.split("-"))
                .mapToInt(parts -> {
                    String menuName = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    int menuPrice = Menu.getMenuFromName(menuName).getCost();
                    return quantity * menuPrice;
                })
                .sum();
    }

    private static void dateIntegerValid(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throwException(DATE_VALID_ERROR.getMessage());
        }
    }

    private static void dateRangeValid(int date) {
        if (date < DATE_MIN.getProperty() || date > DATE_MAX.getProperty()) {
            throwException(DATE_VALID_ERROR.getMessage());
        }
    }

    private static void throwException(String message) {
        IllegalArgumentExceptionThrower
                .throwException(message);
    }

    private static void validOrder(String o) {
        if (!Menu.contains(Arrays.stream(o.split(ORDER_MENU_COUNT_REGEX.getString())).toList().get(0))) {
            throwException(ORDER_VALID_ERROR.getMessage());
        }
    }

    private static void validOrderCount(List<String> order) {
        int count = order.stream()
                .map(menuAndCount -> menuAndCount.split("-"))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.groupingBy(
                        parts -> parts[0],
                        Collectors.summingInt(parts -> Integer.parseInt(parts[1]))
                ))
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (count > ORDER_COUNT_MAX.getProperty()) {
            throwException(MENU_ORDER_OVER_20_ERROR.getMessage());
        }
    }

    private static void validateUniqueOrders(List<String> orders) {
        Map<String, List<String>> menuCountMap = orders.stream()
                .map(order -> order.split(ORDERS_REGEX.getString()))
                .flatMap(Arrays::stream)
                .map(menuAndCount -> menuAndCount.split(ORDER_MENU_COUNT_REGEX.getString()))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.groupingBy(
                        parts -> parts[0],
                        Collectors.mapping(parts -> parts[1], Collectors.toList())
                ));

        if (menuCountMap.values().stream().anyMatch(partsList -> partsList.size() > 1)) {
            throwException(ORDER_VALID_ERROR.getMessage());
        }
    }

    private static void parseOrders(String input) {
        boolean validOrderExists = Arrays.stream(input.split(","))
                .map(String::trim)
                .anyMatch(Validation::stringValid);

        if (!validOrderExists) {
            throwException(ORDER_VALID_ERROR.getMessage());
        }
    }

    private static boolean stringValid(String order) {
        if (order.matches("[a-zA-Z가-힣]+-\\d+")) {
            int quantity = Integer.parseInt(order.split("-")[1]);
            return quantity >= 1;
        }
        return false;
    }

    private static void validateDrinkOrder(String input) {
        int drinkCount = Math.toIntExact(Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(order -> order.matches("[a-zA-Z가-힣]+-\\d+"))
                .map(order -> order.split("-")[0])
                .map(Menu::getMenuFromName)
                .filter(menu -> menu.getMenuDivision() == DRINK)
                .count());

        if (drinkCount == input.split(",").length) {
            throwException(ALL_DRINK_ERROR.getMessage());
        }
    }
}
