package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.dto.OrderDto;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersTest {
    @Test
    void Orders_생성_테스트() {
        // Given
        String inputString = "티본스테이크-1,바비큐립-1";

        // When
        Orders orders = new Orders(inputString);

        assertThat(orders.toDtoList()).isEqualTo(
                List.of(new OrderDto(Menu.T_BONE_STEAK, 1),
                        new OrderDto(Menu.BBQ_RIB, 1)));
    }

    @Test
    void Orders_생성시_형식에_맞지_않는_문자열_입력시_예외가_발생한다() {
        // Given
        String inputString = "티본스테이크a-a,바비큐립a-1a";

        // then
        assertThatThrownBy(() -> new Orders(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Orders_생성시_0이하의_수를_넣으면_예외가_발생한다() {
        // Given
        String inputString = "티본스테이크a-0";

        // then
        assertThatThrownBy(() -> new Orders(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printOrders() {
        // given
        Orders orderList = new Orders("티본스테이크-1,바비큐립-1");

        // when
        String printOrder = orderList.printOrders();

        // then
        assertThat(printOrder).contains("티본스테이크", "바비큐립", "1");
    }

    @Test
    void toDtoList() {
        // given
        Orders orderList = new Orders("티본스테이크-1,바비큐립-1");

        // when
        List<OrderDto> dtoList = orderList.toDtoList();

        // then
        assertThat(dtoList).contains(new OrderDto(Menu.T_BONE_STEAK, 1));
        assertThat(dtoList).contains(new OrderDto(Menu.BBQ_RIB, 1));
    }

    @Test
    void calculateAll() {
        // given
        Orders orderList = new Orders("티본스테이크-1,바비큐립-1");

        // when
        int calculate = orderList.calculateAll();

        assertThat(calculate).isEqualTo(109000);
    }
}