package com.example.td3_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class HelloApplication extends Application {
    //Global attributes
    private static final float DIAM = 30;

    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        //root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 320, 240);
        Timer t = new Timer();

        Circle c = new Circle(Math.random() * (scene.getWidth() - DIAM) + DIAM, Math.random() * (scene.getHeight() - DIAM) + DIAM, DIAM);
        c.setFill(Color.ORANGE);

        c.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mE) {
                c.setCenterX(Math.random() * (scene.getWidth() - 2*DIAM) + DIAM);
                c.setCenterY(Math.random() * (scene.getHeight() - 2*DIAM) + DIAM);
            }
        });
        


        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                c.setCenterX(Math.random() * (scene.getWidth() - 2*DIAM) + DIAM);
                c.setCenterY(Math.random() * (scene.getHeight() - 2*DIAM) + DIAM);
            }
        };

        c.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mE) {
                Text text = new Text("C'est gagné !");
                text.setY(scene.getHeight() - 40);
                double width = text.getLayoutBounds().getWidth();
                text.setX((scene.getWidth() - width) / 2);

                root.getChildren().add(text);
                t.cancel();
            }
        });

        root.getChildren().addAll(c);

        t.schedule(tt, 0,2000);


        stage.setTitle("Clique-moi! - Hugo COLLIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}