package christmas.model;

public class BeforeEventPrice {
    private final int price;

    public BeforeEventPrice(Orders orders) {
        this.price = orders.calculateAll();
    }

    public int getPrice() {
        return price;
    }

    public int printBeforePrice() {
        return price;
    }
}
