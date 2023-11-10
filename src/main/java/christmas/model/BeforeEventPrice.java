package christmas.model;

public class BeforeEventPrice {
    private final int price;

    public BeforeEventPrice(Orders orders) {
        this.price = orders.calculateAll();
    }
    public int printBeforePrice() {
        return price;
    }
}
