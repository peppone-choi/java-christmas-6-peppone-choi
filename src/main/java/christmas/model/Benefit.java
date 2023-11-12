package christmas.model;

import static christmas.config.CommonConfig.DISCOUNT_FORMAT;
import static christmas.config.CommonConfig.NONE;
import static christmas.config.CommonConfigNumber.ZERO;

import java.text.MessageFormat;

public class Benefit {
    private final DiscountAndGift discountAndGift;
    private final int benefitAmount; // TODO : 원시값 포장

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

    public String printBenefit() { // TODO : 출력에 대한 과도한 책임이 지워짐. 책임을 제거할 필요 있음
        if (benefitAmount <= ZERO.getNumber()) {
            return NONE.getString();
        }
        return MessageFormat.format(DISCOUNT_FORMAT.getString(), discountAndGift.getName(), benefitAmount);
    }
}
