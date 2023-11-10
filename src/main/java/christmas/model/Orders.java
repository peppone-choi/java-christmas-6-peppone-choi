package christmas.model;

import static christmas.config.CommonMessage.ORDERS_REGEX;
import static christmas.config.CommonMessage.ORDER_MENU_COUNT_REGEX;
import static java.util.stream.Collectors.toList;

import christmas.util.Validation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private final List<Order> orders;

    public Orders(String orders) {
        Validation.validOrders(orders);
        this.orders = makeList(orders);
    }

    public String printOrders() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.printOrder()).append("\n");
        }
        return stringBuilder.toString();
    }

    public int calculateAll() {
        return orders.stream().mapToInt(Order::calculateOrder).sum();
    }

    private List<Order> makeList(String orders) {
        ArrayList<Order> list;
        List<String> menuAndCount = Arrays.stream(orders.split(ORDERS_REGEX.getMessage())).toList();
        return menuAndCount.stream()
                .map(m -> new Order(Arrays.stream(m.split(ORDER_MENU_COUNT_REGEX.getMessage())).toList().get(0),
                        Integer.parseInt(Arrays.stream(m.split(ORDER_MENU_COUNT_REGEX.getMessage())).toList().get(1))))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}