package image;

import image.color.* ;
import image.*;

public class Image implements ImageInterface {

    private Pixel[][] pixels;
    private int width;
    private int height;
    
    /**
     * Konstruktor, der das Bild konstruiert, mit einem zweidimensionalen Array | Constructor that constructs the image, with a two-dimensional array
     * @param width die Breite des Bildes | @param width the width of the image
     * @param height die Höhe des Bildes | @param height the height of the image 
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new Pixel[width][height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.pixels[i][j] = new Pixel(GrayColor.WHITE);
            }
        }
    }
    
    /**
     * Methode, um die Breite des Bildes zu kennen | Method to know the width of Image
     * @return die Breite des Bildes | @return the width of Image
     */
    public int getWidth() {
        return this.width;
    }
    
    /**
     * Methode, um die Höhe des Bildes zu kennen | Method to know the height of Image
     * @return die Höhe des Bildes | @return the height of Image
     */
    public int getHeight() {
        return this.height;
    }
    
    /**
     * Methode zur Angabe der Koordinaten eines Pixels, wenn dieser Teil des Bildes ist, andernfalls wird eine Ausnahme ausgelöst | Method giving the coordinates of a pixel if it is part of the image, otherwise an exception triggers
     * @param x gehört zur Bildbreite | @param x belongs to the image width
     * @param gehört zur Bildhöhe | @param belongs to the image height
     * @return ein Pixel mit den Koordinaten x und y wirft | @return a pixel of coordinates x and y
     * wenn die Koordinaten des Pixels nicht zum Bild gehören | throws if the coordinates of the pixel do not belong to the image
     */
    public Pixel getPixel(int x, int y) throws UnknownPixelException {
        if ((y < this.height && y >= 0) && (x < this.width && x >= 0)) {
            return this.pixels[x][y];
        }
        throw new UnknownPixelException("Le Pixel n'est pas valide");
    }
    
    /**
     * Methode zum Ändern der Farbe eines Pixels | Method changing the color of a pixel
     * @param x gehört zur Breite eines Pixels | @param x belongs to the width of a pixel
     * @param y gehört zur Höhe eines Pixels | @param y belongs to the height of a pixel
     * @param color gehört zur Klasse GrayColor | @param color belongs to the class GrayColor
     */
    public void changeColorPixel(int x, int y, GrayColor color) throws UnknownPixelException {
        this.getPixel(x, y).setColor(color);
    }
    
    /**
     * Methode, die in das Bild ein «vollständiges» Rechteck mit Farbe, Breite und Höhe zeichnet, wobei die linke obere Ecke bei den Koordinaten (x,y) liegt | method which draws in the image a “full” rectangle of colour, width and height of which the top left corner is at coordinates (x,y)
     * @param x die Abszisse der oberen linken Ecke | @param x the abscisse of the top left corner
     * @param y die Koordinate der oberen linken Ecke | @param y the coordinate of the top left corner
     * @param width die Breite des Rechtecks | @param width the width of the rectangle
     * @param height die Höhe des Rechtecks | @param height the height of the rectangla
     * @param color die Farbe des Rechtecks | @param color the color of the rectangle
     */
    public void fillRectangle(int x, int y, int width, int height, GrayColor color) {
        for (int i = x; i < (x + width); i++) {
            for (int  j = y; j <  (y + height); j++) {
                this.changeColorPixel(i, j, color);
            }
        }
    }

    /**
     * Methode, um die Umrissenlosigkeit des Bildes zu erhalten | methode to get the image's outlineless
     * @param Schwellenwert für den Vergleich von zwei Pixeln und wissen, ob sie zu unterschiedlich sind | @param threshold threshold to compare two pixel and know if they are too different
     */
    public Image edges(int threshold){
        Image im = new Image(this.width, this.height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                Pixel pixi = getPixel(i, j);
                Pixel pixeld = getPixel(i + 1, j);
                Pixel pixelb = getPixel(i, j + 1);

                if ( pixi.colorLevelDifference(pixeld) > threshold && pixi.colorLevelDifference(pixelb) > threshold ) {
                    im.changeColorPixel(i, j, GrayColor.BLACK);
                }
            }
        }
        return im;

    }

    /**
    * Methode, um ein neues Bild wie das erste zu erstellen, aber mit weniger Grauwert | method to make a new image like the initial one but with less level of gray
    * @param nbGrayLevel Anzahl der gewünschten Graustufen | @param nbGrayLevel number of gray level we want
    */
    public Image decreaseNbGrayLevels(int nbGrayLevels){
        int t = 256 / nbGrayLevels;
        Image bild = new Image(this.width, this.height);
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

               Pixel pixies = getPixel(i,j);
               int k = pixies.getColor().getGrayLevel() / t;
               GrayColor l = new GrayColor(k*t);
               bild.changeColorPixel(i, j, l);
            }
        }
        return bild;
    }

}

