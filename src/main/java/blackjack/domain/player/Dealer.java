package blackjack.domain.player;

import blackjack.domain.card.Cards;
import blackjack.domain.card.Deck;
import blackjack.domain.card.Score;

import static blackjack.domain.player.State.START;

public class Dealer implements Player {

    private static final int NUMBER_OF_INITIAL_CARDS = 1;
    private static final int LIMIT_SCORE_TO_HIT = 16;

    private final Name name;
    private final Cards cards;
    private State state;

    public Dealer(){
        name = new Name("딜러");
        cards = new Cards();
        this.state = START;
    }

    private boolean ableToDraw(){
        return cards.getScore().isBelow(LIMIT_SCORE_TO_HIT);
    }

    @Override
    public void initializeCards(Deck deck) {
        for(int i=0; i<NUMBER_OF_INITIAL_CARDS; i++){
            cards.add(deck.draw());
        }
    }

    @Override
    public void drawCard(Deck deck) {
        cards.add(deck.draw());
    }

    @Override
    public void changeState(State state){
        this.state = state;
    }

    @Override
    public boolean isStand() {
        return false;
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Score getScore() {
        return cards.getScore();
    }

    @Override
    public Cards getCards() {
        return cards;
    }
}
