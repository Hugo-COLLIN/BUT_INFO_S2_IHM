package com.example.td1_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();
        //root.setAlignment(Pos.CENTER_LEFT);

        //Left part
        VBox leftPart = new VBox();
        leftPart.setBackground(new Background(new BackgroundFill(Color.BLUE,
                                                        CornerRadii.EMPTY,
                                                        Insets.EMPTY))
        );

            Circle c = new Circle(30);
            c.setFill(Color.BLUE);
            c.setStroke(Color.BLACK);

            Text fr = new Text("F");
            fr.setFont(Font.font("sans-serif", 50));
            fr.setFill(Color.WHITE);

            leftPart.setAlignment(Pos.CENTER);
            leftPart.setPadding(new Insets(10));
            leftPart.getChildren().addAll(c, fr);

        root.setLeft(leftPart);


        //Center text
        VBox centerPart = new VBox();

            Text immat = new Text("AA-123-BB");
            immat.setFont(Font.font("sans-serif", 80));
            leftPart.setPadding(new Insets(10));

            centerPart.getChildren().add(immat);
            centerPart.setAlignment(Pos.CENTER);


        root.setCenter(centerPart);


        //Right part
        VBox rightPart = new VBox();
        rightPart.setBackground(new Background(new BackgroundFill(Color.BLUE,
                CornerRadii.EMPTY,
                Insets.EMPTY))
        );

            Rectangle r = new Rectangle(60,60);
            r.setFill(Color.BLUE);
            r.setStroke(Color.BLACK);

            ImageView img = new ImageView("ge.png");
            img.setFitWidth(60);
            img.setFitHeight(60);


            Text dept = new Text("54");
            dept.setFont(Font.font("sans-serif", 50));
            dept.setFill(Color.WHITE);

            rightPart.setAlignment(Pos.CENTER);
            rightPart.setPadding(new Insets(10));
            rightPart.getChildren().addAll(img, dept);

            root.setRight(rightPart);

        //Right rectangle => Erreur à garder pour se souvenir
        /*
        StackPane rightPart = new StackPane();

            Rectangle r2 = new Rectangle(70,200);
            r2.setFill(Color.BLUE);

            VBox deptBox = new VBox();
                Rectangle img = new Rectangle(30,30);
                img.setFill(Color.BLUE);
                img.setStroke(Color.BLACK);

                Text dept = new Text("35");
                fr.setFont(Font.font("sans-serif", 50));
                fr.setFill(Color.WHITE);

            deptBox.getChildren().addAll(img, dept);


        rightPart.getChildren().addAll(r2,deptBox);
        */


        //immat.setFill(Color.);

        //root.getChildren().addAll(leftPart);















        /*
        Rectangle rect = new Rectangle( 75, 175);
        rect.setFill((Color.BLUE));

        Rectangle rect2 = new Rectangle( 75, 175);
        rect2.setFill((Color.BLUE));

        Circle cercle = new Circle(25);
        cercle.setFill(Color.BLUE);
        cercle.setStroke(Color.WHITE);

        Rectangle img = new Rectangle( 65,65);
        img.setFill(Color.BLUE);
        img.setStroke(Color.WHITE);

        Text f = new Text("F");
        f.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 90));
        f.setFill(Color.WHITE);
        //f.prefHeight(1000);

        Text dpt = new Text("54");
        dpt.setFont(Font.font("helvetica", FontWeight.BOLD, FontPosture.REGULAR, 60));
        dpt.setFill(Color.WHITE);


        root.getChildren().addAll(rect,rect2, cercle, img, f, dpt);
        */

        stage.setScene(new Scene(root));
        stage.setTitle("Immatriculation");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}