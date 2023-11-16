package christmas;

import christmas.controller.ChristmasController;
import christmas.view.Impl.InputViewImpl;
import christmas.view.Impl.OutputViewImpl;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();

        new ChristmasController(inputView, outputView).run();
    }
}
