package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.dto.OrderDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenefitsTest {
    //given
    ExpectedVisitDate expectedVisitDate;
    Orders orders;
    List<OrderDto> orderDtoList;
    Benefits benefits;

    @BeforeEach
    void setup() {
        //given
        expectedVisitDate = new ExpectedVisitDate(3);
        orders = new Orders("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        orderDtoList = orders.toDtoList();
        benefits = new Benefits(orderDtoList, expectedVisitDate);

    }


    @Test
    void printBenefits() {
        // when
        String s = benefits.getBenefits().printBenefits();

        // then
        assertThat(s).isEqualTo("평일 할인: -4,046원 \n"
                + "특별 할인: -1,000원 \n"
                + "크리스마스 디데이 할인: -1,200원 \n"
                + "증정 이벤트: -25,000원 \n");
    }

    @Test
    void sumBenefits() {
        // when
        int sum = benefits.getBenefits().sumBenefits();

        // then
        assertThat(sum).isEqualTo(31246);
    }

    @Test
    void sumDiscount() {
        // when
        int sum = benefits.getBenefits().sumDiscount();

        // then
        assertThat(sum).isEqualTo(6246);
    }
}