package christmas.config;

public enum CommonConfig {
    ORDERS_REGEX(","),
    ORDER_MENU_COUNT_REGEX("-"),
    ORDER_MENU_VALID_MATCHING_REGEX("[a-zA-Z가-힣]+-\\d+"),
    NONE(""),
    PRINT_ORDER_FORMAT("%s\n"),
    EXCEPTION_MESSAGE_FORMAT("%s %s"),
    DECIMAL_FORMAT_PATTON("###,###"),
    GIFT_NOTHING("없음\n"),
    BENEFITS_NOTHING("없음\n"),
    KOREAN_WON_FORMAT("{0}원"),
    ERROR_SUFFIX("[ERROR]"),
    GIFT_NOT_GIVEN("없음"),
    PLUS_ENTER_FORMAT("%s\n%n"),
    DISCOUNT_FORMAT("{0}: -{1}원 \n"),
    PLEASE_INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    PLEASE_INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PRINT_DATE_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n%n"),
    ORDERED_MENU("<주문 메뉴>"),
    BEFORE_EVENT_PRICE("<할인 전 총주문 금액>"),
    GIFT_MENU("<증정 메뉴>"),
    BENEFIT_LIST("<혜택 내역>"),
    BENEFIT_SUM("<총혜택 금액>"),
    AFTER_EVENT_PRICE("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<12월 이벤트 배지>"),
    MENU_NOT_FOUND_ERROR("메뉴가 존재하지 않습니다. 관리자에게 문의하세요.");

    private final String string;

    CommonConfig(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
