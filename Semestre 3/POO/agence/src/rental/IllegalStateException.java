package rental;

/**
 * A class for the Exception IllegalState
 *
 * @author SKOCZYLAS Nestor
 */
public class IllegalStateException extends RuntimeException{
  public IllegalStateException(){
  }

  public IllegalStateException(String msg){
    super(msg);
  }
}
