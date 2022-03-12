
import org.junit.*;
import static org.junit.Assert.*;

import image.* ;
import image.color.*;
import image.Image;


public class ImageTest {

    @Test
    public void testgetWidth() {
        Image image = new Image(20, 10);
        assertEquals(20, image.getWidth());
    }

    @Test
    public void testgetHeight() {
        Image image = new Image(20, 10);
        assertEquals(10, image.getHeight());
    }

    @Test
    public void testgetPixel() {
        Image image = new Image(20, 10);
        assertEquals(new Pixel(GrayColor.WHITE), image.getPixel(1, 1));
    }
    
    @Test
    public void testchangeColorPixel() {
        Image image = new Image(20, 10);
        image.changeColorPixel(1, 1, GrayColor.BLACK);
        assertEquals(new Pixel(GrayColor.BLACK), image.getPixel(1, 1));
    }

    @Test (expected = UnknownPixelException.class)
    public void testfillRectangle() {
        Image image = new Image(25,5);
        image.fillRectangle(2, 1, 10, 6, GrayColor.BLACK);
        for (int i = 2; i < 12; i++)  {
            for (int  j = 1; j < 11; j++) {
                assertEquals(new Pixel(GrayColor.BLACK), image.getPixel(i,j));
            }
        }
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ImageTest.class);
    }
}
