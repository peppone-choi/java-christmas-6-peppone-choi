package christmas.config;

public enum ValidMessage {
    DATE_VALID_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_VALID_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ALL_DRINK_ERROR("음료 메뉴만 주문할 수 없습니다. 다시 입력해 주세요."),
    MENU_ORDER_OVER_20_ERROR("메뉴는 한번에 최대 20개까지 주문 할 수 있습니다. 다시 입력해 주세요."),
    UNDER_10000_ERROR("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다. 다시 입력해 주세요.");
    private final String message;

    ValidMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
