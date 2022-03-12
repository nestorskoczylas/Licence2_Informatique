package image;

import image.util.*;
import image.color.*;

public class ImageMain {

    private static final String STORM = "../images/storm.pgm";
    
    public static void main(String[] args) {

        Image storm = ImageLoader.loadPGM(STORM);

        GrayColor a = new GrayColor(128);
        GrayColor b = new GrayColor(200);
        Image image = new Image(200, 150);
        image.fillRectangle(20, 30, 30, 50, GrayColor.BLACK);
        image.fillRectangle(50, 100, 40, 40, a);
        image.fillRectangle(90, 20, 70, 50, b);

        ImageDisplayer displayer = new ImageDisplayer();
        displayer.display(storm, "Strom", 100, 100);
        storm.edges(50);
        storm.decreaseNbGrayLevels(32);

    }
    
}