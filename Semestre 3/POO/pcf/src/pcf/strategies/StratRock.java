/**
 * A class for rock strategy
 *
 * @author SKOCZYLAS Nestor
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;


public class StratRock implements Strategy{
  private String strat;

  /**
    *
    */
  public StratRock(){
    this.strat = "StratRock";
  }

  /**
    * @return Shape chosen
    */
  public Shape chooseShape(){
    return Shape.ROCK;
  }
}
