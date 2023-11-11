package christmas.dto;

import christmas.model.Menu;

public record OrderDto(Menu orderedMenu, int orderedCount) {
    public int calculateTotalCost() {
        return orderedMenu.getCost() * orderedCount;
    }
}
