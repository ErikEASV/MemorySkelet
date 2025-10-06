package com.example.memoryskelet;

/************************
 * Skelet til Memoryspil
 * EK sep. 2025
 ************************/

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemorySkelet extends Application {
    private String[] brikliste = {"flise1.png", "flise2.png","flise3.png","flise4.png"};

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();

        // Her sættes banen op. Filen brik1.png skal findes i resource
        // Her sættes banen op.
        int i = 0, j = 0;
        int t = 0; // t løber brikliste igennem, så hver brik får et passende id
        while (i < 2) {
            while (j < 2) {
                // Lav hver brik som et objekt "Brik"
                // hver brik får et id fra brikliste. Ens brikker har samme id.
                Brik brik = new Brik(i, j, brikliste[t]);
                ++t;
                // Tilføj brikken til scenegrafen. Da brikkerne er blandede bliver de placeret tilfældigt.
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
        // Find objektet for den brik der blev klikket på
        Brik b = (Brik) event.getSource();
        System.out.println("Briknavn: " + b.getBilledenavn());
        b.vend();
    }

    public static void main(String[] args) {
        launch();
    }
}