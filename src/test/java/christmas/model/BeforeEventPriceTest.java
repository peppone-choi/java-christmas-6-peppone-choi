package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BeforeEventPriceTest {

    @Test
    void getBeforePrice() {
        // given
        Orders orders = new Orders("양송이수프-2");
        BeforeEventPrice beforeEventPrice =  new BeforeEventPrice(orders);

        // when
        int price = beforeEventPrice.getBeforePrice();

        // then
        assertThat(price).isEqualTo(12000);
    }
}