package christmas;

import christmas.controller.ChristmasController;
import christmas.view.Impl.InputViewImpl;
import christmas.view.Impl.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        new ChristmasController(new InputViewImpl(), new OutputViewImpl()).run();
    }
}
