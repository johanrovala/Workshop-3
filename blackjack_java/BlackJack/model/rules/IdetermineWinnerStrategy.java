package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * Created by Ludde on 2015-10-19.
 */
public interface IdetermineWinnerStrategy {
    boolean isDealerWinner(Player a_player, Player a_dealer);

}
