package blackjack.domain.game;

import blackjack.domain.YesOrNo;
import blackjack.domain.card.Deck;
import blackjack.domain.player.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static blackjack.domain.player.State.HIT;
import static blackjack.domain.player.State.STAND;

public class BlackJackGame {

    private final Deck deck = new Deck();

    public BlackJackGame(){
    }

    public Players createPlayers(String allName){
        List<String> names = Arrays.asList(allName.split(","));
        List<Player> players = new ArrayList<>();

        players.add(new Dealer());
        players.addAll(names.stream()
                .map(Name::new)
                .map(Gambler::new)
                .collect(Collectors.toList()));
        return new Players(players);
    }

    public void initPlayerCards(Players players){
        for(Player player : players){
            player.initializeCards(deck);
        }
    }

    public void giveCard(Player player) {
        if(!player.isStand()){
            player.drawCard(deck);
        }
    }

    public void giveCard(Player player, String askDrawOrNot) {
        if(YesOrNo.of(askDrawOrNot) == YesOrNo.YES){
            player.drawCard(deck);
            player.changeState(HIT);
        }

        if(YesOrNo.of(askDrawOrNot) == YesOrNo.NO){
            player.changeState(STAND);
        }
    }
}
