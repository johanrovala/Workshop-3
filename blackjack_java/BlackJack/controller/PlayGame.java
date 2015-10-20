package BlackJack.controller;

import BlackJack.model.Observer;
import BlackJack.view.IView;
import BlackJack.model.Game;

import java.io.IOException;


public class PlayGame implements Observer {

    private Game m_game;
    private IView m_view;

    public PlayGame(Game a_game, IView a_view) {
        m_game = a_game;
        m_view = a_view;

        m_game.addObserver(this);
    }

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

    public void update() {
        System.out.println("Dealing cards..");
        try {
            Thread.sleep(1500);
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.m_view.DisplayDealerHand(this.m_game.GetDealerHand(), this.m_game.GetDealerScore());
        this.m_view.DisplayPlayerHand(this.m_game.GetPlayerHand(), this.m_game.GetPlayerScore());
    }
}