package blackjack.domain.player;

import blackjack.domain.card.Cards;
import blackjack.domain.card.Deck;
import blackjack.domain.card.Score;

import static blackjack.domain.player.State.STAND;
import static blackjack.domain.player.State.START;

public class Gambler implements Player{

    private static final int NUMBER_OF_INITIAL_CARDS = 2;

    private final Name name;
    private final Cards cards;
    private State state;

    public Gambler(Name name){
        this.name= name;
        this.cards = new Cards();
        this.state = START;
    }

    @Override
    public void initializeCards(Deck deck){
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
    public boolean isStand(){
        return state == STAND;
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
