package christmas.model;

import java.util.List;

public class OrderList {
    private final List<Order> orders;

    public OrderList(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
