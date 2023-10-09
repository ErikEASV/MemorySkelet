package com.example.memoryskelet;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MemorySkelet extends Application {

    private Brik[][] brikker;

    @Override
    public void start(Stage stage) throws IOException {
        Pane scenegraf = new Pane();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Brik b = (Brik)e.getSource();
                b.vend();
            }
        };

        brikker = new Brik[5][5];
        for (int i=0; i<5; i++)
            for (int j=0; j<5; j++) {
                brikker[i][j] = new Brik(i, j, "brik1.png");
                scenegraf.getChildren().add(brikker[i][j]);
                brikker[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
            }

        Scene scene = new Scene(scenegraf, 600, 600);
        stage.setTitle("MemorySkelet!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}