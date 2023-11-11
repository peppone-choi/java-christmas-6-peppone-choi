package christmas.controller;

import static christmas.config.CommonConfigNumber.GIFT_GIVEN_COUNT;

import christmas.model.BeforeEventPrice;
import christmas.model.BenefitSum;
import christmas.model.Benefits;
import christmas.model.ExpectedVisitDate;
import christmas.model.Gift;
import christmas.model.Menu;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        ExpectedVisitDate date = date();
        Orders orders = getOrders();
        BeforeEventPrice beforeEventPrice = new BeforeEventPrice(orders);
        printBeforeEventPrice(beforeEventPrice);
        Gift gift = new Gift(beforeEventPrice.getPrice(), Menu.CHAMPAGNE.getName(), GIFT_GIVEN_COUNT.getNumber());
        printGift(gift);
        Benefits benefits = new Benefits(orders.toDtoList(), date);
        printBenefits(benefits);
        BenefitSum benefitSum = new BenefitSum(benefits);
        printBenefitSum(benefitSum);
    }

    private void printBenefits(Benefits benefits) {
        outputView.printBenefits(benefits.printBenefits());
    }

    public Orders readOrders(String orders) {
        return new Orders(orders);
    }

    public ExpectedVisitDate readDate(int date) {
        return new ExpectedVisitDate(date);
    }

    private void printGift(Gift gift) {
        outputView.printGift(gift.printGift());
    }

    private void printBeforeEventPrice(BeforeEventPrice beforeEventPrice) {
        outputView.printBeforePrice(beforeEventPrice.printBeforePrice());
    }

    private void printBenefitSum(BenefitSum benefitSum) {
        outputView.printBenefitSum(benefitSum.printBenefitSum());
    }

    private Orders getOrders() {
        Orders orders = readOrders(inputView.readOrder());
        outputView.printMenu(orders.printOrders());
        return orders;
    }

    private ExpectedVisitDate date() {
        int date = inputView.readDate();
        return readDate(date);
    }


}
