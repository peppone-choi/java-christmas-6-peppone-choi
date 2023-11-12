package christmas.model;

import static christmas.config.OrderConfig.ORDER_PRINT_FORMAT;

import christmas.dto.OrderDto;
import java.text.MessageFormat;

public class Order {
    private final Menu orderedMenu;
    private final int orderedCount; // TODO : 원시값 포장

    public Order(String menu, Integer count) {
        this.orderedMenu = Menu.getMenuFromName(menu);
        this.orderedCount = count;
    }

    public OrderDto toDto() {
        return new OrderDto(orderedMenu, orderedCount);
    }

    public String printOrder() {
        return MessageFormat.format(ORDER_PRINT_FORMAT.getString(), orderedMenu.getName(), orderedCount);
    }    // TODO : 출력에 대한 과도한 책임이 지워짐. 책임을 제거할 필요 있음

    public int calculateOrder() {
        return orderedMenu.getCost() * orderedCount;
    }
}
