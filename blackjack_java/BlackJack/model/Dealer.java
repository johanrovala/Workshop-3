package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
    private IdetermineWinnerStrategy m_winnerRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
      m_winnerRule = a_rulesFactory.getWinnerOnEqualRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
     // Card c;
      //c = m_deck.GetCard();
      //c.Show(true);
      creatObject();
      a_player.DealCard(creatObject());
      
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player, Player a_dealer) {
    return m_winnerRule.isDealerWinner(a_player, a_dealer);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }

  public boolean Stand(){
    if (m_deck != null){
      ShowHand();
      for (Card c : GetHand()){
        c.Show(true);
      }
      while (m_hitRule.DoHit(this)){
       // Card c = m_deck.GetCard();
       // c.Show(true);

        creatObject();
        DealCard(creatObject());

      }
      return true;
    }
    return false;
  }

  public Card creatObject(){
    Card c = m_deck.GetCard();
    c.Show(true);
    return c;
  }



  
}