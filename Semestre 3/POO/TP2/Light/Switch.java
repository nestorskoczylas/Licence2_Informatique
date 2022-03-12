
/**
 * Write a description of class Switch here.
 *
 * @author SKOCZYLAS Nestor
 * @version septembre 2019
 */
public class Switch {

    private Lightbulb light;

    /**
     * "Turn off" (false) or "turn on" (true) the light
     * 
     * @param lightbulb initialized bulb
     */
    public Switch(Lightbulb lightbulb) {
        this.light = lightbulb;
    }

    /**
     * change the state of the Lightbuld according to its current state
     * 
     * @param lightbulb
     */
    public void push() {
        if (this.light.getState()) {
            this.light.setState(false);
        } else {
            this.light.setState(true);
        }

    }
}