package christmas.model;

public class BenefitSum {
    private final int benefitSum;

    public BenefitSum(Benefits benefits) {
        this.benefitSum = benefits.sumBenefits();
    }

    public int getBenefitSum() {
        return benefitSum;
    }
}
