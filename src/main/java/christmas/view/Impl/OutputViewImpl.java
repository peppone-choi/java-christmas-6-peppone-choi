package christmas.view.Impl;

import static christmas.config.CommonConfig.KOREAN_WON_FORMAT;

import christmas.view.OutputView;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class OutputViewImpl implements OutputView {

    DecimalFormat df = new DecimalFormat("###,###");

    @Override
    public void printMenu(String orders) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        System.out.println("<주문 메뉴>");
        System.out.println(orders);
    }

    @Override
    public void printBeforePrice(int price) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%s\n%n", MessageFormat.format(KOREAN_WON_FORMAT.getString(), df.format(price)));
    }

    @Override
    public void printGift(String gift) {
        System.out.println("<증정 메뉴>");
        System.out.printf("%s\n%n", gift);
    }

    @Override
    public void printBenefits(String benefits) {
        System.out.println("<혜택 내역>");
        System.out.println(benefits);
    }

    @Override
    public void printBenefitSum(int benefitSum) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%s\n%n", MessageFormat.format(KOREAN_WON_FORMAT.getString(), df.format(benefitSum)));
    }
}
