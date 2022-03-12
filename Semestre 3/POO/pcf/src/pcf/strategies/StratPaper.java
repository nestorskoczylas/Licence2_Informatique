/**
 * A class for a Paper Strategy
 *
 * @author SKOCZYLAS Nestor
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;

public class StratPaper implements Strategy{
  private String strat;

  /**
    *
    */
  public StratPaper(){
    this.strat = "StratPaper";
  }

  public Shape chooseShape(){
    return Shape.PAPER;
  }
}
