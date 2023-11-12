package christmas.model;

import static christmas.config.CommonConfig.DISCOUNT_FORMAT;
import static christmas.config.CommonConfig.NONE;

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
            return NONE.getString();
        }
        return MessageFormat.format(DISCOUNT_FORMAT.getString(), discountAndGift.getName(), benefitAmount);
    }
}
