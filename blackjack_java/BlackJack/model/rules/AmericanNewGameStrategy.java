package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    dealCard(a_deck, a_player,true);

    dealCard(a_deck,a_dealer,true);

    dealCard(a_deck,a_player,true);

    dealCard(a_deck,a_dealer,false);

    return true;
  }
    private void dealCard(Deck a_deck, Player a_player, boolean show) {
        Card c;
        c = a_deck.GetCard();
        c.Show(show);
        a_player.DealCard(c);
    }
}