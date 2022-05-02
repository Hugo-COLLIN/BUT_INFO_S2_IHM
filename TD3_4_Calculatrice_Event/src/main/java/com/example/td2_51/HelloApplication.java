package com.example.td2_51;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


    class Boutons {

    }


    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        GridPane app = new GridPane();

        app.setHgap(10);
        app.setVgap(10);
        app.setPadding(new Insets(10, 10, 10, 10));

        TextField resField = new TextField();
        app.add(resField,0,0, 4,1);



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
                int fI = i, fJ = j;
                Button b = new Button(String.valueOf(touches[i][j]));
                b.setPadding(new Insets(10));

                switch (touches[i][j]) {
                    case '=' :
                        break;
                    case 'C':
                        b.addEventHandler(ActionEvent.ACTION,
                                actionEvent -> resField.clear());
                        break;
                    default:
                        b.setOnMousePressed(mouseEvent -> resField.appendText(String.valueOf(touches[fI][fJ])));
                }



                app.add(b,j, i + 1);
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