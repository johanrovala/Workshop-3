package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
      a_view.DisplayWelcomeMessage();
      IView.selectedAction input;
      a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
      a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

      if (a_game.IsGameOver()) {
          a_view.DisplayGameOver(a_game.IsDealerWinner());
      }

      input = a_view.selectAction();

      if (input == IView.selectedAction.Play) {
          a_game.NewGame();
      } else if (input == IView.selectedAction.Hit) {
          a_game.Hit();
      } else if (input == IView.selectedAction.Stand) {
          a_game.Stand();
      }
      return input != IView.selectedAction.Quit;
  }
}