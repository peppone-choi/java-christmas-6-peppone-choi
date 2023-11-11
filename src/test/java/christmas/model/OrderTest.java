package christmas.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static christmas.model.Menu.RED_WINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.dto.OrderDto;
import org.junit.jupiter.api.Test;


class OrderTest {
    @Test
    void 목록에_없는_메뉴를_Order로_등록하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Order("멸치조림", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void toDto() {
        assertSimpleTest(() -> assertThat(new Order("레드와인", 1).toDto())
                .isEqualTo(new OrderDto(RED_WINE, 1)));
    }

    @Test
    void printOrder() {
        assertSimpleTest(() -> assertThat(new Order("레드와인", 1).printOrder())
                .contains("레드와인", "1개"));
    }

    @Test
    void calculateOrder() {
        assertSimpleTest(() -> assertThat(new Order("레드와인", 2).calculateOrder())
                .isEqualTo(120000));
    }
}