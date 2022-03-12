/**
 * A class for a Random Strategy
 *
 * @author SKOCZYLAS Nestor
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;


public class RandomStrat implements Strategy{
  private String strat;

  public RandomStrat(){
    this.strat = "SissorsRandom";
  }

  public Shape chooseShape(){
    int n = (int) (Math.random()*3);
    return Shape.values()[n];
  }
}
