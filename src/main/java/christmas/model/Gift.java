package christmas.model;

import static christmas.config.CommonConfig.GIFT_NOT_GIVEN;
import static christmas.config.CommonConfigNumber.GIFT_GIVEN_MONEY;
import static christmas.config.OrderConfig.ORDER_PRINT_FORMAT;

import java.text.MessageFormat;

public class Gift {
    private Menu name;
    private int count;

    public Gift(int money, String name, int count) {
        ValidMoney(money, name, count);
    }

    private void ValidMoney(int money, String name, int count) {
        this.name = null;
        this.count = 0;
        if (money >= GIFT_GIVEN_MONEY.getNumber()) {
            this.name = Menu.getMenuFromName(name);
            this.count = count;
        }
    }

    public String printGift() {
        if (name == null) return GIFT_NOT_GIVEN.getString();
        return MessageFormat.format(ORDER_PRINT_FORMAT.getString(), name.getName(), count);
    }
}
