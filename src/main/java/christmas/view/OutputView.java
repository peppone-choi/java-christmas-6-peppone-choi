package christmas.view;

public interface OutputView {
    void printDate(int date);
    void printMenu(String orders);
    void printBeforePrice(int price);
    void printGift(String gift);
    void printBenefits(String benefits);
    void printBenefitSum(int benefitSum);
    void printAfterEventPrice(int afterEventPrice);
    void printBadge(String badgeName);
}