package com.example.memoryskelet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Brik extends ImageView {

    private Image forside, bagside;

    public Brik(int x, int y, String filnavn) {
        forside = new Image(getClass().getResource(filnavn).toString());
        bagside = new Image(getClass().getResource("bagside.png").toString());
        setImage(forside);
        setX(x*80);
        setY(y*80);
    }

    public void vend() {
        System.out.println("brik " + getX() + "," + getY());
        setImage(bagside);
    }
}


