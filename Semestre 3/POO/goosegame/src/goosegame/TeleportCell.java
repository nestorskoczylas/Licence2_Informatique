package goosegame;

/**
 * A class for Teleport cell
 *
 * @author SKOCZYLAS Nestor
 */
  public class TeleportCell extends StandardCell{

    private final int target;

    public TeleportCell(int index, int target){
      super(index);
      this.target = target;
    }

    public int handleMove(int dicethrow){
      return this.target;
    }

    public String toString(){
      return new String("Cell "+index);
    }
  }
