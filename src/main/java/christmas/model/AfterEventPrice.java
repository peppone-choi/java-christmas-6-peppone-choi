package christmas.model;

public class AfterEventPrice {
    private final int afterEventPrice; // TODO : 원시값 포장

    public AfterEventPrice(BeforeEventPrice beforeEventPrice, Benefits benefits) {
        this.afterEventPrice = beforeEventPrice.getBeforePrice() - benefits.getBenefits().sumDiscount();
    }

    public int getAfterEventPrice() {
        return afterEventPrice;
    }
}
