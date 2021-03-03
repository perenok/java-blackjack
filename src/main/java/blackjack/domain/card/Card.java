package blackjack.domain.card;

import java.util.*;

public class Card {

    private static final List<Card> cards = new ArrayList<>();
    static {
        for(Suit suit : Suit.values()){
            Arrays.stream(Denomination.values())
                    .forEach(denomination -> cards.add(new Card(suit, denomination)));
        }
    }

    private final Suit suit;
    private final Denomination denomination;

    private Card(Suit suit, Denomination denomination){
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(Suit suit, Denomination denomination) {
        return cards.stream()
                .filter(card -> card.equals(new Card(suit, denomination)))
                .findFirst().orElseThrow(()-> new IllegalArgumentException("유효하지 않은 카드입니다."));
    }

    public static LinkedList<Card> getCards(){
        return new LinkedList<>(cards);
    }
    // TODO :: CARDS 이름 중의적 (캐싱된 카드들과 플레이어가 들고 있는 카드들)

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return denomination == card.denomination && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }
}
