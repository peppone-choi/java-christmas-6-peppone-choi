package christmas.model;

public class AfterEventPrice {
    private final int afterEventPrice;

    public AfterEventPrice(BeforeEventPrice beforeEventPrice, Benefits benefits) {
        this.afterEventPrice = beforeEventPrice.getPrice() - benefits.sumDiscount();
    }

    public int getAfterEventPrice() {
        return afterEventPrice;
    }
}
