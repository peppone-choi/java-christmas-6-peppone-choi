package christmas.view.Impl;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.config.CommonMessage.PLASE_INPUT_ORDER;
import static christmas.config.CommonMessage.PLEASE_INPUT_DATE;

import christmas.util.Validation;
import christmas.view.InputView;

public class InputViewImpl implements InputView {

    @Override
    public int readDate() {
        while (true) {
            try {
                System.out.println(PLEASE_INPUT_DATE.getMessage());
                return returnDate(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String readOrder() {
        while (true) {
            try {
                System.out.println(PLASE_INPUT_ORDER.getMessage());
                return returnOrders(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int returnDate(String input) {
        Validation.validDate(input);
        return Integer.parseInt(input);
    }

    private String returnOrders(String input) {
        Validation.validOrders(input);
        return input;
    }
}
