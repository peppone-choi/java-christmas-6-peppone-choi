package christmas.view.Impl;

import christmas.view.OutputView;

public class OutputViewImpl implements OutputView {

    @Override
    public void printMenu(String orders) {
        System.out.println("<주문 메뉴>");
        System.out.print(orders);
    }
}
