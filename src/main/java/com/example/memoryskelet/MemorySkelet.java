package com.example.memoryskelet;

/************************
 * Skelet til Memoryspil
 * EK okt. 2025
 ************************/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemorySkelet extends Application {

    // Array af filnavne til brikkerne. Brikkerne skal findes i resources-kataloget
    private String[] brikliste = {"flise1.png", "flise2.png","flise3.png","flise4.png"};

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();

        // Her sættes banen op.
        int i = 0, j = 0;
        int t = 0; // t løber brikliste igennem, så hver brik får et passende filnavn
        while (i < 2) {
            while (j < 2) {
                // Lav hver brik som et objekt "Brik"
                // hver brik får et id fra brikliste. Ens brikker har samme id.
                Brik brik = new Brik(i, j, brikliste[t]);
                ++t; // tæl t op, så vi bevæger os frem i briklisten
                // Tilføj brikken til scenegrafen.
                scenegraf.getChildren().add(brik);
                // Tilføj museklik til brikken
                brik.setOnMouseClicked(event -> klik(event));
                ++j;
            }
            ++i;
            j = 0;
        }

        // Sæt scenen op
        Scene scene = new Scene(scenegraf, 600, 600);
        stage.setTitle("MemorySkelet!");
        stage.setScene(scene);
        stage.show();
    }

    public void klik(MouseEvent event) {
        // Her laver vi arbejdet når spilleren trykker på en brik
        // Find objektet for den brik der blev klikket på
        Brik b = (Brik) event.getSource();
        System.out.println("Briknavn: " + b.getBilledenavn());
        // lige nu vender vi bare brikken, men vi skal findes ud af om det er første eller
        // anden brik og der er et match.
        b.vend();
    }

    public static void main(String[] args) {
        launch();
    }
}