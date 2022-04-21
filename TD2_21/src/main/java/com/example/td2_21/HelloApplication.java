package com.example.td2_21;

import javafx.application.Application;
import javafx.beans.property.SetProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        //Top
        Button btnSuperman = new Button("Superman");
        root.setTop(btnSuperman);
        btnSuperman.setPadding(new Insets(5));
        BorderPane.setAlignment(btnSuperman, Pos.CENTER);

        //Page
        StackPane logo = new StackPane();
        logo.setPadding(new Insets(10));

        Circle blue = new Circle(0,0,60);
        blue.setFill(Color.BLUE);
        blue.setStroke(Color.BLACK);

        Circle yellow = new Circle(0,0,50);
        yellow.setFill(Color.YELLOW);
        yellow.setStroke(Color.BLACK);

        Text sText = new Text("S");
        sText.setFill(Color.RED);
        sText.setStroke(Color.BLACK);
        sText.setFont(Font.font("serif", FontWeight.BOLD, FontPosture.REGULAR,90));


        logo.getChildren().addAll(blue,yellow,sText);

        root.setCenter(logo);


        //Bottom
        HBox boxBottom = new HBox(1);
        BorderPane.setAlignment(boxBottom, Pos.CENTER);
        //boxBottom.setMaxWidth(Double.MAX_VALUE, Double.MAX_VALUE);
        String [] btnList = {"Un", "Deux", "Trois", "Quatre", "Cinq", "Six"};
        for (String s : btnList)
        {
            Button btnText = new Button(s);
            btnText.setPadding(new Insets(5));
            //btnText.setMargin();
            boxBottom.getChildren().add(btnText);
            //BorderPane.setAlignment(btnText,Pos.CENTER);
        }
        boxBottom.setPadding(new Insets(10));
        boxBottom.setSpacing(3);
        boxBottom.setAlignment(Pos.CENTER);
        root.setBottom(boxBottom);

        //root.getChildren().addAll(btnSuperman, logo);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}