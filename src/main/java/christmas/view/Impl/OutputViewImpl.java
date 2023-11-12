package christmas.view.Impl;

import static christmas.config.CommonConfig.AFTER_EVENT_PRICE;
import static christmas.config.CommonConfig.BEFORE_EVENT_PRICE;
import static christmas.config.CommonConfig.BENEFIT_LIST;
import static christmas.config.CommonConfig.BENEFIT_SUM;
import static christmas.config.CommonConfig.EVENT_BADGE;
import static christmas.config.CommonConfig.GIFT_MENU;
import static christmas.config.CommonConfig.KOREAN_WON_FORMAT;
import static christmas.config.CommonConfig.ORDERED_MENU;
import static christmas.config.CommonConfig.PLUS_ENTER_FORMAT;
import static christmas.config.CommonConfig.PRINT_DATE_FORMAT;

import christmas.view.OutputView;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class OutputViewImpl implements OutputView {

    DecimalFormat df = new DecimalFormat("###,###");

    @Override
    public void printDate(int date) {
        System.out.printf(PRINT_DATE_FORMAT.getString(), date);
    }

    @Override
    public void printMenu(String orders) {
        System.out.println(ORDERED_MENU.getString());
        System.out.println(orders);
    }

    @Override
    public void printBeforePrice(int price) {
        System.out.println(BEFORE_EVENT_PRICE.getString());
        System.out.printf(PLUS_ENTER_FORMAT.getString(), MessageFormat.format(KOREAN_WON_FORMAT.getString(), df.format(price)));
    }

    @Override
    public void printGift(String gift) {
        System.out.println(GIFT_MENU.getString());
        System.out.printf(PLUS_ENTER_FORMAT.getString(), gift);
    }

    @Override
    public void printBenefits(String benefits) {
        System.out.println(BENEFIT_LIST.getString());
        System.out.println(benefits);
    }

    @Override
    public void printBenefitSum(int benefitSum) {
        System.out.println(BENEFIT_SUM.getString());
        System.out.printf(PLUS_ENTER_FORMAT.getString(), MessageFormat.format(KOREAN_WON_FORMAT.getString(), df.format(benefitSum)));
    }

    @Override
    public void printAfterEventPrice(int afterEventPrice) {
        System.out.println(AFTER_EVENT_PRICE.getString());
        System.out.printf(PLUS_ENTER_FORMAT.getString(), MessageFormat.format(KOREAN_WON_FORMAT.getString(), df.format(afterEventPrice)));
    }

    @Override
    public void printBadge(String badgeName) {
        System.out.println(EVENT_BADGE.getString());
        System.out.println(badgeName);
    }
}
