package blackjack.domain;

import blackjack.domain.card.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SuitTest {
    @Test
    @DisplayName("of를 통한 enum 객체 테스트")
    void testSuit() {
        Suit suit = Suit.of("클로버");
        assertThat(suit).isEqualTo(Suit.CLUB);
    }
}