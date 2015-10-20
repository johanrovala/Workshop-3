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

  public boolean Play() {
      m_view.DisplayWelcomeMessage();
      IView.selectedAction input;
      m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
      m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

      if (m_game.IsGameOver()) {
          m_view.DisplayGameOver(m_game.IsDealerWinner());
      }

      input = m_view.selectAction();

      if (input == IView.selectedAction.Play) {
          m_game.NewGame();
      } else if (input == IView.selectedAction.Hit) {
          m_game.Hit();
      } else if (input == IView.selectedAction.Stand) {
          m_game.Stand();
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