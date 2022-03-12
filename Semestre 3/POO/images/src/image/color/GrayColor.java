

package image.color;

/**
 * Klasse, die Parameter definiert | class who define parameters
 */

public class GrayColor {

    public static final GrayColor WHITE = new GrayColor(255);
    public static final GrayColor BLACK = new GrayColor(0);
    private int grayLevel;
    private double alpha = 1;

    /**
     * Konstruktor, um die Grau-Ebene zu bauen | constructor to build the level of gray
     * @param Level eine Zahl zwischen 0 und 255 | @param level a number between 0 and 255
     */
    public GrayColor(int level){
        this.grayLevel = level;
    }

    /**
     * Methode, um den Grauwert zu kennen | method to know the level of gray
     * @Rückgabe der Grau-Ebene | @return the level of gray
     */
    public int getGrayLevel() {
        return this.grayLevel;
    }


    /**
     * Methode, um das Alpha zu wissen, das der Transparenz entspricht | method to know the alpha who corresponds to transparency
     * @Rückgabe des Alphas | @return the alpha
     */
    public double getAlpha() {
        return this.alpha;
    }

    /**
     * Methode, um den Wert von Alpha einzustellen | method to set the value of alpha
     * @param ein Wert des Alphas, das gesetzt werden soll | @param a value of the alpha who want to set
     */
    public void setAlpha(double a) {
        this.alpha = a;
    }

    /**
     * Methode, um zu wissen, ob ein Objekt o gleich diesem ist | method to know if a object o is equal to this
     * @param oder Objekt o | @param o objet o
     * @return True, wenn o gleich diesem ist oder sonst Falsch | @return True if it's o equal to this or false else
     */
    public boolean equals(Object o){ 
        if (o instanceof GrayColor){ 

            GrayColor other = (GrayColor) o;
            return (this.grayLevel == other.grayLevel) && (this.alpha == other.alpha);
        }
        else
            return false;
    }

}

