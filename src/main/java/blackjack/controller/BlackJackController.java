package blackjack.controller;

import blackjack.domain.game.BlackJackGame;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Gambler;
import blackjack.domain.player.Player;
import blackjack.domain.player.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {
    static final BlackJackGame blackJackGame = new BlackJackGame(); // 요건 대화 필요

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Players players = blackJackGame.createPlayers(InputView.askPlayerNames());
        blackJackGame.initPlayerCards(players);
        OutputView.printPlayers(players);

        giveGamblerCard(players);
        giveDealerCard(players);
    }

    private static void giveGamblerCard(Players players) {
        List<Player> gamblers = players.players().stream()
                .filter(player -> player instanceof Gambler)
                .collect(Collectors.toList());



        for (Player gambler : gamblers) {
            if (!gambler.isStand()) {
                String hitOrStand = InputView.askDrawOrNot(gambler);
                blackJackGame.giveCard(gambler, hitOrStand);
            }
        }
    }

    private static void giveDealerCard(Players players) {
        players.players().stream()
                .filter(player -> player instanceof Dealer)
                .peek(player -> blackJackGame.giveCard(player))
                .findFirst();
    }
}

/*
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

 */
