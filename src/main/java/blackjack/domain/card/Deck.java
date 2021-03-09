package blackjack.domain.card;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private final LinkedList<Card> deck;

    public Deck() {
        deck = Card.cashingCards();
        Collections.shuffle(deck);
    }

    public Card draw() {
        if (deck.size() <= 0) {
            throw new IndexOutOfBoundsException("deck에 남아있는 카드가 존재하지 않습니다.");
        }
        return deck.pop();
    }
}
