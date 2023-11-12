package christmas.config;

public enum CommonConfig {
    ORDERS_REGEX(","),
    ORDER_MENU_COUNT_REGEX("-"),
    KOREAN_WON_FORMAT("{0}원"),
    ERROR_SUFFIX("[ERROR]"),
    GIFT_NOT_GIVEN("없음"),
    PLEASE_INPUT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    PLASE_INPUT_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PRINT_DATE_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n%n"),
    MENU_NOT_FOUND_ERROR("메뉴가 존재하지 않습니다. 관리자에게 문의하세요.");

    private final String string;

    CommonConfig(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
