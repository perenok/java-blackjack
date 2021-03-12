package blackjack.domain.player;

import blackjack.domain.card.Deck;
import blackjack.domain.game.WinOrLose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GamblerTest {

    Gambler gambler;

    @BeforeEach
    void beforeEach() {
        //given
        gambler = new Gambler("pobi", new Money(10000));
    }

    @Test
    @DisplayName("카드 초기화 테스트")
    void testInitializeCards() {
        //given
        Deck deck = new Deck();

        //when
        gambler.initializeCards(deck);

        //then
        assertThat(gambler.cards().countCards()).isEqualTo(2);
    }

    @Test
    @DisplayName("겜블러 수익률 계산 테스트")
    void testCalculateProfit() {
        //when
        this.gambler.calculateProfit(WinOrLose.WIN_BLACK_JACK);

        //then
        assertThat(this.gambler.money()).isEqualTo(new Money(15000));
    }

    @Test
    @DisplayName("Money inverse 테스트")
    void testInverseMoney() {
        //when
        Money inverseMoney = gambler.inverseMoney();

        //then
        assertThat(inverseMoney).isEqualTo(new Money(-10000));
    }

    @Test
    @DisplayName("이름을 통해 객체 구분 테스트")
    void testIsSameName() {
        //given
        Gambler gambler1 = new Gambler("pobi", new Money(10000));
        Gambler gambler2 = new Gambler("jason", new Money(20000));

        //when
        boolean test1 = gambler.isSameName(gambler1);
        boolean test2 = gambler.isSameName(gambler2);

        //then
        assertThat(test1).isTrue();
        assertThat(test2).isFalse();
    }
}
