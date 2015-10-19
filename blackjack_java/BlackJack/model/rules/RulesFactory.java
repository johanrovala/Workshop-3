package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }

    public IdetermineWinnerStrategy getWinnerOnEqualRule() { return new standardWinnerOnEqualScoreStrategy();}

}