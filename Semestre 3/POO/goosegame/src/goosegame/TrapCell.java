package goosegame;

/**
 * A class for TrapCell
 *
 * @author SKOCZYLAS Nestor
 */
public class TrapCell extends StandardCell{

  /** Creates a trap cell at the number Cell
    * @param index the number of the Cell
    */
  public TrapCell(int index){
    super(index);
  }

  public boolean canBeLeft(){
    return false;
  }

  public String toString(){
    return new String("Cell" + index + "index");
  }

}
