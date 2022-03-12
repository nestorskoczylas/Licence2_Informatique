import org.junit.*;
import static org.junit.Assert.*;

import factory.Robot;   
import factory.util.*;   

public class RobotTest {	


    @Test
    public void robotCarryNoBoxWhenCreated() {
	Robot robbie = new Robot();
	assertFalse(robbie.carryBox());
    }


    public void robotCanTakeBoxIfNotCarrying() {
        // situation initiale : un robot et une caisse
        Robot robbie = new Robot();
        Box b = new Box(3);
        // précondition : robot peut prendre une caisse, si il ne la porte pas
        assertFalse(robbie.carryBox());
        // exécution de la méthode testée
        robbie.take(b);
    }


    public void robotCannotTakeBoxIfAlreadyCarrying() {
        // situation initiale : un robot et une caisse
        Robot robbie = new Robot();
        Box b = new Box(3);
        // précondition : robot ne peut pas prendre la boîte si elle est déjà en place
        assertFalse(robbie.carryBox());
        // exécution de la méthode testée
        robbie.take(b);
    }

    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}
