package christmas.model;

import static christmas.config.OrderConfig.ORDER_PRINT_FORMAT;

import java.text.MessageFormat;

public class Order {
    private final Menu orderedMenu;
    private final int orderedCount;

    public Order(String menu, Integer count) {
        this.orderedMenu = Menu.getMenuFromName(menu);
        this.orderedCount = count;
    }

    public String printOrder() {
        return MessageFormat.format(ORDER_PRINT_FORMAT.getString(), orderedMenu.getName(), orderedCount);
    }
}
