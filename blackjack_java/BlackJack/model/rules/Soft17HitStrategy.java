package BlackJack.model.rules;

import BlackJack.model.Player;

/**
 * Created by Ludde on 2015-10-19.
 */
public class Soft17HitStrategy implements IHitStrategy {

    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
        if(a_dealer.hasAcePlusSix()) {
            return true;
        } else {
            return a_dealer.CalcScore() < g_hitLimit;
        }
    }
}
