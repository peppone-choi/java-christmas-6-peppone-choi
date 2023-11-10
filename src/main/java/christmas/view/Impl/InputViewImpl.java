package christmas.view.Impl;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.config.CommonMessage.PLEASE_INPUT_DATE;
import static christmas.util.Validation.dateValid;

import christmas.view.InputView;

public class InputViewImpl implements InputView {
    @Override
    public int readDate() {
        while (true) {
            try {
                System.out.println(PLEASE_INPUT_DATE.getMessage());
                return dateReturn(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int dateReturn(String input) {
        dateValid(input);
        return Integer.parseInt(input);
    }
}
