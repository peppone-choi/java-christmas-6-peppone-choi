package christmas.controller;

import christmas.model.ExpectedVisitDate;
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
        Orders orders = readOrders(inputView.readOrder());
        outputView.printMenu(orders.printOrders());
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
