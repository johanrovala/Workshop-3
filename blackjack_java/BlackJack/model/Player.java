package BlackJack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Player implements Subject{

  private List<Card> m_hand;
  protected final int g_maxScore = 21;
    ArrayList<Observer> observers = new ArrayList<>();


    public Player()
  {
    m_hand = new LinkedList<>();
      observers = new ArrayList<>();
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
      notifyObserver();
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear();
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand)
    {
      c.Show(true);
    }
  }
  
  public int CalcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
            //6,11      Testing soft17rule
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    
    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
    public boolean hasAcePlusSix() {
        if(this.CalcScore() == 7 || this.CalcScore() == 17) {
            for(Card c : this.GetHand()) {
                if(c.GetValue() == Card.Value.Ace) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getMaxScore() {
        return this.g_maxScore;
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}