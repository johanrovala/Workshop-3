package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * Created by Ludde on 2015-10-19.
 * This rule will give the Player an advantage against the dealer when the Scores are equal.
 */
public class PlayerAdvantageOnEqualScoreStrategy implements IdetermineWinnerStrategy {

    public boolean isDealerWinner(Player a_player, Player a_dealer) {
        final int maxScore = a_player.getMaxScore();
        if (a_player.CalcScore() > maxScore) {
            return true;
        } else if (a_dealer.CalcScore() > maxScore) {
            return false;
        }
        return a_dealer.CalcScore() > a_player.CalcScore();     //note: '>=' in standard rule, '>' here.
    }
}
