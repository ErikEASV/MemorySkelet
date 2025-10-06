package com.example.memoryskelet;

/***************
 Brik er et kort i et vendespil
 Den har to billeder: en forside og en bagside.
 Npr man klikker på brikken "vendes" brikken
 */

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Brik extends ImageView {

    private Image forside, bagside;
    private String billedenavn;

    public Brik(int x, int y, String filnavn) {
        // Sæt ny brik op med forside- og bagsidebillede (alle brikker har samme bagside).
        // Vis forsiden som udgangspunkt
        billedenavn = filnavn;
        forside = new Image(getClass().getResource(filnavn).toString());
        bagside = new Image(getClass().getResource("bagside.png").toString());
        setImage(bagside);
        // Placér brikken: lav selv koordinaterne, så brikkerne spredes
        setX(x*123);
        setY(y*123);
    }

    public void vend() {
        // Her skal brikken vendes.
        // Lige nu udskrives lidt oplysninger om brikken og bagsiden vises
        System.out.println("brik " + getX() + "," + getY());
        if (getImage() == bagside)
            setImage(forside);
        else
            setImage(bagside);
    }

    public String getBilledenavn() {
        return billedenavn;
    }
}