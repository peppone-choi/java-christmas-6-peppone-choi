package christmas.model;

import static christmas.util.Validation.validBeforePrice;

public class BeforeEventPrice {
    private final int price;

    public BeforeEventPrice(Orders orders) {
        this.price = orders.calculateAll();
    }
    public int printBeforePrice() {
        return price;
    }
}
