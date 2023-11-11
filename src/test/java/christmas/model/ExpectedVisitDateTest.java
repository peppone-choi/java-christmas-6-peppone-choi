package christmas.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ExpectedVisitDateTest {

    @Test
    void getDate() {
        assertSimpleTest(() -> assertThat(new ExpectedVisitDate(25).getDate()).isEqualTo(25));
    }

    @Test
    void 일과_삼십일_사이가_아닌_숫자를_넣으면_예외가_발생한다() {
        assertThatThrownBy(() -> new ExpectedVisitDate(32)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ExpectedVisitDate(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}