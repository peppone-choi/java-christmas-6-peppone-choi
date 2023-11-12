package christmas.model;

public class BenefitSum {
    private final Sum benefitSum;

    public BenefitSum(Benefits benefits) {
        this.benefitSum = new Sum(benefits.getBenefits().sumBenefits());
    }

    public Sum getBenefitSum() {
        return benefitSum;
    }
}
