package christmas.model;

import static christmas.config.CommonConfig.ORDERS_REGEX;
import static christmas.config.CommonConfig.ORDER_MENU_COUNT_REGEX;
import static christmas.config.CommonConfig.PRINT_ORDER_FORMAT;

import christmas.dto.OrderDto;
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
        return orders.stream().map(order -> PRINT_ORDER_FORMAT.getString().formatted(order.printOrder()))
                .collect(Collectors.joining());
    }

    public List<OrderDto> toDtoList() {
        return orders.stream().map(Order::toDto).collect(Collectors.toList());
    }

    public int calculateAll() {
        return orders.stream().mapToInt(Order::calculateOrder).sum();
    }

    private List<Order> makeList(String orders) {
        List<String> menuAndCount = Arrays.stream(orders.split(ORDERS_REGEX.getString())).toList();
        return menuAndCount.stream()
                .map(m -> new Order(Arrays.stream(m.split(ORDER_MENU_COUNT_REGEX.getString())).toList().get(0),
                        Integer.parseInt(Arrays.stream(m.split(ORDER_MENU_COUNT_REGEX.getString())).toList().get(1))))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
