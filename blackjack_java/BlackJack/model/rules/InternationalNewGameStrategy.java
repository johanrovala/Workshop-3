package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
      dealAndShow(a_deck,a_player);
      dealAndShow(a_deck,a_dealer);
      dealAndShow(a_deck,a_player);
    return true;
  }

    private void dealAndShow(Deck a_deck, Player a_player) {
        Card c;
        c = a_deck.GetCard();
        c.Show(true);
        a_player.DealCard(c);
    }
}