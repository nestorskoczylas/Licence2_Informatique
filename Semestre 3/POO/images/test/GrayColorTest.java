

import static org.junit.Assert.*;
import org.junit.*;

import image.color.GrayColor;
import image.color.*;


public class GrayColorTest {

	@Test
    public void testgetGrayLevel(){
        GrayColor gray = new GrayColor(100);
        assertEquals(100, gray.getGrayLevel());
    }

    @Test
    public void testgetAlpha() {
        GrayColor x = new GrayColor(100);
        assertEquals(1, x.getAlpha(), 0);
    }
    
    @Test
    public void testsetAlpha() {
        GrayColor y = new GrayColor(100);
        y.setAlpha(1);
        assertEquals(1, y.getAlpha(), 0);
    }

    @Test
    public void testequalsTrue() {
        GrayColor a = new GrayColor(100);
        GrayColor b = new GrayColor(100);
        assertTrue(a.equals( a ) );
        assertTrue(a.equals( b ) );
    }

    @Test
    public void testequalsFalse() {
        GrayColor a = new GrayColor(100);
        GrayColor b = new GrayColor(150);
        assertFalse(a.equals ( b ) );
    }

    @Test
    public void testequalsFalseEver() {
        GrayColor a = new GrayColor(100);
        assertFalse(a.equals( new Object() ) );
		assertFalse(a.equals( null ) );
    }
	

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(GrayColorTest.class);
    }   
}

