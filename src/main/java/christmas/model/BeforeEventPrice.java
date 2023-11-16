package christmas.model;

public class BeforeEventPrice {
    private final int price; // TODO : 원시값 포장

    public BeforeEventPrice(Orders orders) {
        this.price = orders.calculateAll();
    }

    public int getBeforePrice() {
        return price;
    }
}
