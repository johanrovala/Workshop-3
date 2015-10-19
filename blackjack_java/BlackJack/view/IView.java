package BlackJack.view;

import BlackJack.model.Game;

public interface IView
{
  enum selectedAction{Quit, Play, Stand, Hit, Unknown}
  void DisplayWelcomeMessage();
  int GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
  selectedAction selectAction();
}