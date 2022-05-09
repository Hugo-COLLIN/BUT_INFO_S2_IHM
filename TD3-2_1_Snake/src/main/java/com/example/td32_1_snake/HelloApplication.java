package com.example.td32_1_snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private static final int MAZE_WIDTH = 25;
    private static final int MAZE_HEIGHT = 20;
    private static final int SQUARE_EDGE = 20;

    private int snakeSize = 5;


    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();
        Scene scene = new Scene(root);

        ArrayList<Rectangle> bodySnake = new ArrayList<Rectangle>();


        for (int i = 0 ; i < MAZE_WIDTH ; i ++)
        {
            for (int j = 0 ; j < MAZE_HEIGHT ; j ++)
            {
                Rectangle floor = new Rectangle(SQUARE_EDGE,SQUARE_EDGE);
                floor.setFill(Color.BLUE);
                floor.setStroke(Color.BLACK);
                root.add(floor, i, j);
            }
        }

        /*for (int i = 0 ; i < 200 ; i ++)
        {
            Rectangle head = new Rectangle(SQUARE_EDGE,SQUARE_EDGE);
            head.setFill(Color.ORANGE);
            head.setStroke(Color.BLACK);
            root.add(head, (int)(Math.random() * (MAZE_WIDTH - 8) + 5), (int)(Math.random() * (MAZE_HEIGHT - 8) + 5));
            //            root.add(head, (int)(Math.random() * (MAZE_WIDTH - 2 * SQUARE_EDGE) + SQUARE_EDGE), (int)(Math.random() * (MAZE_WIDTH - 2 * SQUARE_EDGE) + SQUARE_EDGE));
        }*/

        Rectangle head = new Rectangle(SQUARE_EDGE,SQUARE_EDGE);
        head.setFill(Color.ORANGE);
        head.setStroke(Color.BLACK);
        bodySnake.add(head);
        root.add(head, 6, 1);


        stage.setTitle("Snake! - Hugo COLLIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}