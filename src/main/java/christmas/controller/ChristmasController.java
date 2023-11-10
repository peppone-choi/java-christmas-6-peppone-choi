package christmas.controller;

import christmas.model.ExpectedVisitDate;
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
        date();
    }

    private void date() {
        int date = inputView.readDate();
        ExpectedVisitDate expectedVisitDate = readDate(date);
    }

    public ExpectedVisitDate readDate(int date) {
        return new ExpectedVisitDate(date);
    }
}
