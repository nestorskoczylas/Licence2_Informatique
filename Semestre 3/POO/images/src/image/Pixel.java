package image;


import image.color.*;
import image.*;

public class Pixel {

    private GrayColor color;

    /**
     * Konstruktor, um die Farbe zu erstellen | constructor to build the color
     */
    public Pixel(GrayColor color) {
        this.color = color;
    }
    /**
     * Methode, um die Farbe einzustellen | methode to set the color 
     * @param i ths Wert oh die Farbe, die gesetzt werden soll | @param i ths value oh the color who want to set
    */
        public void setColor(GrayColor i) {
            this.color = i;

        }
    /**
     * Methode, um die Farbe zu kennen | methode to know the color
     * @Rückgabe der Farbe | @return the color
     */
        public GrayColor getColor() {
            return this.color;
        }
    /**
     * Methode entspricht zu wissen, ob zwei Pixel die gleiche Farbe haben | methode equals to know if two pixels have the same color
     * @param e Objekt, das wir mit unserem Pixel vergleichen wollen | @param e object we want to compare to our pixel
     */
        public boolean equals(Object o){ 
        if (o instanceof Pixel){ 

            Pixel other = (Pixel) o;
            return (this.color == other.color);
        }
        else
            return false;
    }


     /**
      * Methode, um die Graudifferenz zwischen zwei Pixeln zu haben | methode to have the difference of gray between two pixels
      * @param p Pixel, die vergleichen wollen | @param p pixel who want to compare
      * @return die Graudifferenz zwischen den beiden | @return the difference of gray between the two
     */
        public int colorLevelDifference(Pixel p) {
            int res = this.color.getGrayLevel() - p.color.getGrayLevel();
            return Math.abs(res);
        }
}