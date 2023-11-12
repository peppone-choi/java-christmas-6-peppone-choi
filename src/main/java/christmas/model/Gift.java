package christmas.model;

import static christmas.config.CommonConfigNumber.GIFT_GIVEN_MONEY;
import static christmas.model.Menu.NONE;

public class Gift {
    private Menu name;
    private Count count;

    public Gift(int money, String name, int count) {
        ValidMoney(money, name, count);
    }

    private void ValidMoney(int money, String name, int count) {
        this.name = NONE;
        this.count = new Count(0);
        if (money >= GIFT_GIVEN_MONEY.getNumber()) {
            this.name = Menu.getMenuFromName(name);
            this.count = new Count(count);
        }
    }

    public Menu getName() {
        return name;
    }

    public Count getCount() {
        return count;
    }
}
