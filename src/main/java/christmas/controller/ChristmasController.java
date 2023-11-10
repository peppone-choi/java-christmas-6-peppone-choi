package christmas.controller;

import christmas.model.BeforeEventPrice;
import christmas.model.ExpectedVisitDate;
import christmas.model.Orders;
import christmas.util.Validation;
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
        Orders orders = orderValidation();

        printBeforeEventPrice(orders);
    }

    private Orders orderValidation() {
        Orders orders = getOrders();
        try {
            Validation.validBeforePrice(orders.calculateAll());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    private void printBeforeEventPrice(Orders orders) {
        BeforeEventPrice beforeEventPrice = new BeforeEventPrice(orders);
        outputView.printBeforePrice(beforeEventPrice.printBeforePrice());
    }

    private Orders getOrders() {
        Orders orders = readOrders(inputView.readOrder());
        outputView.printMenu(orders.printOrders());
        return orders;
    }

    public ExpectedVisitDate readDate(int date) {
        return new ExpectedVisitDate(date);
    }

    private ExpectedVisitDate date() {
        int date = inputView.readDate();
        return readDate(date);
    }

    public Orders readOrders(String orders) {
        return new Orders(orders);
    }
}
