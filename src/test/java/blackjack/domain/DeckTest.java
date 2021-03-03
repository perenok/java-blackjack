package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DeckTest {

    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    @DisplayName("deck 생성")
    void testDeckInit() {
        assertThat(deck).isNotNull();
    }

    @Test
    void testDrawCard() {

        Card card = deck.draw();
        assertThat(card).isNotNull();
    }

    @Test
    void test() {

        for (int i = 0; i < 52; i++) {
            deck.draw();
        }

        assertThatThrownBy(() -> {
            deck.draw();
        }).isInstanceOf(NoSuchElementException.class);
    }
}
