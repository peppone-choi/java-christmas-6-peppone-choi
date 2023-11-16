package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.dto.OrderDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfterEventPriceTest {
    ExpectedVisitDate expectedVisitDate;
    Orders orders;
    List<OrderDto> orderDtoList;
    Benefits benefits;
    BeforeEventPrice beforeEventPrice;
    AfterEventPrice afterEventPrice;
    @BeforeEach
    void afterEventPrice_생성_테스트() {
        expectedVisitDate = new ExpectedVisitDate(3);
        orders = new Orders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        orderDtoList = orders.toDtoList();
        benefits = new Benefits(orderDtoList, expectedVisitDate);
        beforeEventPrice = new BeforeEventPrice(orders);
        afterEventPrice = new AfterEventPrice(beforeEventPrice, benefits);
    }

    @Test
    void getAfterEventPrice() {
        int price = afterEventPrice.getAfterEventPrice();
        assertThat(price).isEqualTo(135754);
    }
}