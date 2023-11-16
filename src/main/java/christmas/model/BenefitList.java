package christmas.model;

import static christmas.config.CommonConfig.BENEFITS_NOTHING;
import static christmas.config.CommonConfigNumber.ZERO;
import static christmas.model.DiscountAndGift.GIFT_EVENT;

import java.util.List;

public class BenefitList {
    private final List<Benefit> benefits;

    public BenefitList(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public String printBenefits() {
        int sum = benefits.stream().mapToInt(Benefit::getBenefitAmount).sum();
        if (sum <= ZERO.getNumber()) {
            return BENEFITS_NOTHING.getString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        benefits.forEach(benefit -> stringBuilder.append(benefit.printBenefit()));
        return stringBuilder.toString();
    }

    public int sumBenefits() {
        return benefits.stream()
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }

    public int sumDiscount() {
        return benefits.stream()
                .filter(benefit -> !benefit.getDiscountAndGift().equals(GIFT_EVENT))
                .mapToInt(Benefit::getBenefitAmount)
                .sum();
    }
}
