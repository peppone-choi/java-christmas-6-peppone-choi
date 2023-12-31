package christmas.controller;

import static christmas.config.CommonConfig.GIFT_NOTHING;
import static christmas.config.CommonConfig.PRINT_ORDER_FORMAT;
import static christmas.config.CommonConfigNumber.GIFT_GIVEN_COUNT;
import static christmas.config.CommonConfigNumber.ZERO;
import static christmas.config.OrderConfig.ORDER_PRINT_FORMAT;

import christmas.model.AfterEventPrice;
import christmas.model.Badge;
import christmas.model.BeforeEventPrice;
import christmas.model.BenefitSum;
import christmas.model.Benefits;
import christmas.model.ExpectedVisitDate;
import christmas.model.Gift;
import christmas.model.Menu;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.text.MessageFormat;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        ExpectedVisitDate date = getExpectedVisitDate();
        Orders orders = getOrders();
        outputView.printDate(date.getDate().getDate());
        BeforeEventPrice beforeEventPrice = getBeforeEventPrice(orders);
        printGift(beforeEventPrice);
        Benefits benefits = getBenefits(orders, date);
        BenefitSum benefitSum = getBenefitSum(benefits);
        printAfterEventPrice(beforeEventPrice, benefits);
        printBadge(benefitSum);
    }

    private ExpectedVisitDate getExpectedVisitDate() {
        return date();
    }

    private Orders readOrders(String orders) {
        return new Orders(orders);
    }

    private ExpectedVisitDate readDate(int date) {
        return new ExpectedVisitDate(date);
    }

    private BeforeEventPrice getBeforeEventPrice(Orders orders) {
        BeforeEventPrice beforeEventPrice = new BeforeEventPrice(orders);
        printBeforeEventPrice(beforeEventPrice);
        return beforeEventPrice;
    }

    private void printGift(BeforeEventPrice beforeEventPrice) {
        Gift gift = new Gift(beforeEventPrice.getBeforePrice(), Menu.CHAMPAGNE.getName(), GIFT_GIVEN_COUNT.getNumber());
        printGift(gift);
    }

    private Benefits getBenefits(Orders orders, ExpectedVisitDate date) {
        Benefits benefits = new Benefits(orders.toDtoList(), date);
        printBenefits(benefits);
        return benefits;
    }

    private BenefitSum getBenefitSum(Benefits benefits) {
        BenefitSum benefitSum = new BenefitSum(benefits);
        printBenefitSum(benefitSum);
        return benefitSum;
    }

    private void printAfterEventPrice(BeforeEventPrice beforeEventPrice, Benefits benefits) {
        AfterEventPrice afterEventPrice = new AfterEventPrice(beforeEventPrice, benefits);
        printAfterEventPrice(afterEventPrice);
    }

    private void printBadge(BenefitSum benefitSum) {
        Badge badge = getBadge(benefitSum.getBenefitSum().getSum());
        printBadge(badge);
    }

    private void printGift(Gift gift) {
        if (gift.getCount().getCount() <= 0) {
            outputView.printGift(GIFT_NOTHING.getString());
        }
        if (gift.getCount().getCount() > 0) {
            outputView.printGift(PRINT_ORDER_FORMAT.getString().formatted(
                    MessageFormat.format(ORDER_PRINT_FORMAT.getString(), gift.getName().getName(),
                            gift.getCount().getCount())));
        }
    }

    private void printBeforeEventPrice(BeforeEventPrice beforeEventPrice) {
        outputView.printBeforePrice(beforeEventPrice.getBeforePrice());
    }

    private void printBenefitSum(BenefitSum benefitSum) {
        int sum = ZERO.getNumber();
        if (benefitSum.getBenefitSum().getSum() > ZERO.getNumber()) {
            sum = -benefitSum.getBenefitSum().getSum();
        }
        outputView.printBenefitSum(sum);
    }

    private void printAfterEventPrice(AfterEventPrice afterEventPrice) {
        outputView.printAfterEventPrice(afterEventPrice.getAfterEventPrice());
    }

    private void printBenefits(Benefits benefits) {
        outputView.printBenefits(benefits.getBenefits().printBenefits());
    }

    private Badge getBadge(int benefitSum) {
        if (benefitSum >= Badge.SANTA.getCost()) {
            return Badge.SANTA;
        }
        if (benefitSum >= Badge.TREE.getCost()) {
            return Badge.TREE;
        }
        if (benefitSum >= Badge.STAR.getCost()) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    private void printBadge(Badge badge) {
        outputView.printBadge(badge.getBadgeName());
    }

    private Orders getOrders() {
        Orders orders = readOrders(inputView.readOrder());
        outputView.printMenu(orders);
        return orders;
    }

    private ExpectedVisitDate date() {
        int date = inputView.readDate();
        return readDate(date);
    }


}
