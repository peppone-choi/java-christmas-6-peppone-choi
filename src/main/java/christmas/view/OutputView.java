package christmas.view;

import christmas.model.Gift;
import christmas.model.Orders;

public interface OutputView {
    void printDate(int date);
    void printMenu(Orders orders);
    void printBeforePrice(int price);
    void printGift(String gift);
    void printBenefits(String benefits);
    void printBenefitSum(int benefitSum);
    void printAfterEventPrice(int afterEventPrice);
    void printBadge(String badgeName);
}