import static org.junit.Assert.*;
import org.junit.*;

import image.Pixel;
import image.color.GrayColor;
import image.*;

public class PixelTest {

    @Test
    public void testsetColor() {
        Pixel pixel = new Pixel(new GrayColor(100));
        pixel.setColor(new GrayColor(100));
        assertEquals(new GrayColor(100), pixel.getColor());
    }
    
    @Test
    public void testgetColor() {
        assertEquals(new GrayColor(100), new Pixel(new GrayColor(100)).getColor());
    }
    
    @Test
    public void testequalsTrue() {
        Pixel pixel = new Pixel(new GrayColor(100));
        Pixel pixel2 = new Pixel(new GrayColor(100));
        assertTrue(pixel.equals ( pixel ) );
        assertTrue(pixel2.equals ( pixel ) );
    }
    
    @Test
    public void testequalsFalse() {
        Pixel pixel = new Pixel(new GrayColor(100));
        Pixel pixel2 = new Pixel(new GrayColor(150));
        assertFalse(pixel2.equals ( pixel ) );
    }
    
    @Test
    public void testequalsFalseEver() {
        Pixel pixel = new Pixel(new GrayColor(100));
        assertFalse(pixel.equals( new Object() ) );
        assertFalse(pixel.equals( null ) );
    }
    
    @Test
    public void colorLevelDifferenceWhenEquals() {
        Pixel pix = new Pixel(new GrayColor(50));
        assertEquals(pix.colorLevelDifference(50),0);
  }
    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PixelTest.class);
    }  
}
