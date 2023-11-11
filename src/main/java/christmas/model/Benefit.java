package christmas.model;

import java.text.MessageFormat;

public class Benefit {
    private final DiscountAndGift discountAndGift;
    private final int benefitAmount;

    public Benefit(DiscountAndGift discountAndGift, int benefitAmount) {
        this.discountAndGift = discountAndGift;
        this.benefitAmount = benefitAmount;
    }

    public DiscountAndGift getDiscountAndGift() {
        return discountAndGift;
    }

    public int getBenefitAmount() {
        return benefitAmount;
    }

    public String printBenefit() {
        if (benefitAmount <= 0) {
            return "";
        }
        return MessageFormat.format("{0}: -{1}원 \n", discountAndGift.getName(), benefitAmount);
    }
}
