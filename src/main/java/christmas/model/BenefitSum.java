package christmas.model;

public class BenefitSum {
    private final int benefitSum; // TODO : 원시값 포장

    public BenefitSum(Benefits benefits) {
        this.benefitSum = benefits.getBenefits().sumBenefits();
    }

    public int getBenefitSum() {
        return benefitSum;
    }
}
