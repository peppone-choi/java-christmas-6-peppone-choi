package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.config.CommonMessage.PLEASE_INPUT_DATE;
import static christmas.util.Validation.dateValid;

public interface InputView {
    int readDate();
}
