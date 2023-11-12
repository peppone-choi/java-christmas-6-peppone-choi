package christmas.model;

import static christmas.config.OrderConfig.ORDER_PRINT_FORMAT;

import christmas.dto.OrderDto;
import java.text.MessageFormat;

public class Order {
    private final Menu orderedMenu;
    private final Count orderedCount;

    public Order(String menu, Integer count) {
        this.orderedMenu = Menu.getMenuFromName(menu);
        this.orderedCount = new Count(count);
    }

    public OrderDto toDto() {
        return new OrderDto(orderedMenu, orderedCount.getCount());
    }

    public String printOrder() {
        return MessageFormat.format(ORDER_PRINT_FORMAT.getString(), orderedMenu.getName(), orderedCount.getCount());
    }

    public int calculateOrder() {
        return orderedMenu.getCost() * orderedCount.getCount();
    }
}
