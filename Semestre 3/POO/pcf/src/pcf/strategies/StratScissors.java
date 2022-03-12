/**
 * A class for Scissors Strategy
 *
 * @author SKOCZYLAS Nestor
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;

public class StratScissors implements Strategy{
  private String strat;

  /**
    *
    */
  public StratScissors(){
    this.strat = "StratScissors";
  }

  /**
    * @return Shape chosen
    */
  public Shape chooseShape(){
    return Shape.SCISSORS;
  }
}
