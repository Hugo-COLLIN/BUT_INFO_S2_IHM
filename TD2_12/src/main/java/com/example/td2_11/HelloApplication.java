package com.example.td2_11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Creation des elements
        HBox root = new HBox(10);
        Button btnOK = new Button ("OK");
        Button btnLog = new Button("Login");
        Button btnSave = new Button("Save");
        Button btnMulti = new Button("Texte\nsur plusieurs\nlignes.");

        //Modification des attributs des elements
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().add(btnOK);

        btnLog.setTextFill(Color.BLUE);
        ImageView imgv = new ImageView("img.png");

        imgv.setFitWidth(50);
        imgv.setPreserveRatio(true);
        imgv.setSmooth(true);

        btnLog.setGraphic(imgv);
        btnLog.setContentDisplay(ContentDisplay.TOP);
        root.getChildren().add(btnLog);

        btnSave.setDefaultButton(true);
        root.getChildren().add(btnSave);

        btnMulti.setTextAlignment(TextAlignment.RIGHT);
        root.getChildren().add(btnMulti);


        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}