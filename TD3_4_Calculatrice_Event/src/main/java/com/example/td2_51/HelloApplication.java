package com.example.td2_51;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //Att
    Pane root = new Pane();
    GridPane app = new GridPane();

    TextField resField = new TextField();

    //Vars
    String num1 ="";
    String num2 ="";
    String op ;
    double res = 0;
    boolean oldop = false;

    private class Auditeur implements EventHandler<ActionEvent> {
        public void handle (ActionEvent e)
        {
            String button = ((Button)e.getSource()).getText();
            switch (button)
            {
                case "=" :
                    break;
                case "C":
                    resField.clear();
                    break;
                default:
                    resField.appendText(String.valueOf(button));
            }
        }
    }


    @Override
    public void start(Stage stage) throws IOException {


        app.setHgap(10);
        app.setVgap(10);
        app.setPadding(new Insets(10, 10, 10, 10));

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

                b.setOnMousePressed(mouseEvent -> {
                    switch (touches[fI][fJ]) {
                        case '=':
                            System.out.println(oldop);
                            if (oldop) {
                                System.out.println("OK");

                                //resField.setText(String.valueOf(res));

                                res = calc(num1, num2, op);
                                resField.clear();
                                resField.appendText(String.valueOf(res));
                                oldop = false;
                                num2 = "";

                            }
                            break;
                        case '+':
                            if (!oldop) {
                                oldop = true;
                                op = "+";
                                //resField.clear();
                                resField.appendText(op);
                            } else {
                                res = calc(num1, num2, op);
                                num1 = String.valueOf(res);
                                num2 = "";
                                op = "+";
                                    //resField.clear();
                                    resField.appendText(op);
                                oldop = true;
                            }
                            break;
                        case 'C':
                            num1 = "";
                            num2 = "";
                            res = 0;
                            oldop = false;
                            /*b.addEventHandler(ActionEvent.ACTION,
                                    actionEvent -> */
                                            resField.clear();
                        //);
                            break;
                        default:
                            if (!oldop)
                                num1 += touches[fI][fJ];
                            else
                                num2 += touches[fI][fJ];

                            //b.setOnMousePressed(mouseEvent ->
                                    resField.appendText(String.valueOf(touches[fI][fJ]));
                        //);
                    }
                });


                app.add(b,j, i + 1);
            }
        }




        root.getChildren().addAll(app);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public int calc (String n1 , String n2 , String op) {
        n1 = n1.split("\\.")[0];
        n2 = n2.split("\\.")[0];
        switch (op) {
            case "+":
                return Integer.parseInt(n1) + Integer.parseInt(n2);
            case "-":
                return Integer.parseInt(n1) - Integer.parseInt(n2);
            case "*":
                return Integer.parseInt(n1) * Integer.parseInt(n2);
            case "/":
                return Integer.parseInt(n1) / Integer.parseInt(n2);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}