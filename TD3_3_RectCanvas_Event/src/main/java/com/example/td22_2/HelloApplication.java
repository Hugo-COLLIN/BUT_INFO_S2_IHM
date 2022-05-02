package com.example.td22_2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class HelloApplication extends Application {
    //Attributes
    public static final int SIZE = 300;
    int contentNb;
    int contentSize;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);




        // HEADER > HBOX
        HBox header = new HBox();
        header.setAlignment(Pos.BASELINE_CENTER);
        header.setSpacing(5);

        // > Contenu HBox
        Text txtNb = new Text("Nb");
        TextField fieldNb = new TextField("1000");

        Text txtSize = new Text("Taille");
        TextField fieldSize = new TextField(String.valueOf(SIZE));

        header.getChildren().addAll(txtNb, fieldNb, txtSize, fieldSize);


        //CENTER > CANVAS
        Canvas canvas = new Canvas(SIZE,SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // ACTIONS NB
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent kE) {
                if (kE.getCode() == KeyCode.ENTER)
                {
                    try {
                        contentNb = Integer.parseInt(fieldNb.getText());
                        //System.out.println(fieldNb.getText());
                        contentSize = Integer.parseInt(fieldSize.getText());
                        //System.out.println(fieldSize.getText());

                        gc.clearRect(0,0,SIZE,SIZE);

                        for (int i = 0; i < contentNb; i ++)
                        {
                            gc.setFill(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255), Math.random()));
                            gc.fillRect(Math.random() * SIZE, Math.random() * SIZE, Math.random() * contentSize, Math.random() * contentSize);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Attention : le texte rentré n'est pas un nombre entier");
                        //Pas un nombre
                    }
                }
            }
        });

        // STRUCTURATION : AJOUT A ROOT
        root.setTop(header);
        root.setCenter(canvas);

        /*
        Canvas canvas = new Canvas(SIZE,SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Scanner sc = new Scanner(System.in);
        int nbRect;

        do {
            System.out.print("Rentrer un nombre entier de carrés à afficher : ");
            nbRect = sc.nextInt();
        }
        while (nbRect < 0);


        for (int i = 0 ; i < nbRect ; i ++)
        {
            gc.setFill(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255), Math.random()));
            gc.fillRect(Math.random() * SIZE, Math.random() * SIZE, Math.random() * SIZE, Math.random() * SIZE);
        }

        root.getChildren().add(canvas);
        */
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}