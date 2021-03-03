package blackjack.view;

import blackjack.domain.card.Cards;
import blackjack.domain.player.Player;
import blackjack.domain.player.Players;

import java.util.stream.Collectors;

public class OutputView {

    private static final String FORMAT = "%s카드 : %s" + System.lineSeparator();

    private OutputView(){}

    public static void printMessage(final Object message) {
        System.out.println(message);
    }

    public static void printMessageByFormat(final String format, final Object... message) {
        System.out.printf(format, message);
    }

    // TODO :: 네이밍
    public static void printPlayers(Players players){
        for(Player player : players){
            printPlayer(player);
        }
    }

    public static void printPlayer(Player player){
        String cardInfo = player.getCards().cards().stream()
                .map(card -> card.getDenomination().denomination() + card.getSuit().suit())
                .collect(Collectors.joining(", "));
        printMessageByFormat(FORMAT, player.getName().name(), cardInfo);
    }
}
