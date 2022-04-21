package com.example.td2_51;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        GridPane app = new GridPane();

        //TextField resField = new TextField();
        //app.add(resField,0,0,4,0);



        char [] [] touches = {
                {'7', '8', '9', '+'},
                {'4', '5', '6', '-'},
                {'1', '2', '3', 'x'},
                {'C', '0', '=', '/'}
        };

        for (int i = 0 ; i < 4 ; i ++)
        {
            for (int j = 0 ; j < 4 ; j ++)
            {
                Button b = new Button(String.valueOf(touches[i][j]));
                b.setPadding(new Insets(10));
                app.add(b,j,i);
            }
        }



        root.getChildren().addAll(app);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}