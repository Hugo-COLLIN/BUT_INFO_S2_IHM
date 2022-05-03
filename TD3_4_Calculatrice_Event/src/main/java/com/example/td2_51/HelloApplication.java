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

    char [] [] touches = {
            {'7', '8', '9', '+'},
            {'4', '5', '6', '-'},
            {'1', '2', '3', 'x'},
            {'C', '0', '=', '/'}
    };

    //Vars
    String num1 ="";
    String num2 ="";
    String op ;
    double res = 0;
    char oldkey = '=';
    boolean oldop = false, oldeq = true;

    /*
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
     */


    @Override
    public void start(Stage stage) throws IOException {


        app.setHgap(10);
        app.setVgap(10);
        app.setPadding(new Insets(10, 10, 10, 10));

        app.add(resField,0,0, 4,1);

        System.out.println("oldop\toldeq\tnum1\tnum2\tres");
        for (int i = 0 ; i < 4 ; i ++)
        {
            for (int j = 0 ; j < 4 ; j ++)
            {
                int fI = i, fJ = j;
                Button b = new Button(String.valueOf(touches[i][j]));
                b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                b.setPadding(new Insets(10));

                b.setOnMousePressed(mouseEvent -> {
                    this.typing(b.getText().charAt(0));
                });

                app.add(b,j, i + 1);
            }
        }

        root.getChildren().addAll(app);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void typing (char key)
    {
        switch (key) {
            case '=':
                if (oldop) {
                    System.out.println("OK");

                    //resField.setText(String.valueOf(res));

                    res = calc(num1, num2, op);
                    resField.clear();
                    resField.appendText(String.valueOf(res));
                    oldop = false;
                    num1 = String.valueOf(res);
                    num2 = "";
                    oldeq = true;
                }
                break;
            case '+': case '-': case 'x': case '/':
                if (!(oldkey == '=' || oldkey == '+' || oldkey == '-' || oldkey == 'x' || oldkey == '/'))
                {
                    //if (oldkey != '=' && (oldkey == '+' || oldkey == '-' || oldkey == 'x' || oldkey == '/'))
                    //                    num1 = resField.getText();
                    op = String.valueOf(key);
                    if (!oldop) {
                        oldop = true;
                        //resField.clear();
                        resField.appendText(op);
                    } else {
                        res = calc(num1, num2, op);
                        num1 = String.valueOf(res);
                        num2 = "";
                        resField.clear();
                        resField.appendText(op);
                        oldop = true;
                    }
                }

                break;
            case 'C':
                num1 = "";
                num2 = "";
                res = 0;
                oldop = false;
                resField.clear();
                break;

            default:
                if (oldeq)
                {
                    num1 = "";
                    num2 = "";
                    res = 0;
                    oldop = false;
                    oldeq = false;
                    resField.clear();
                }
                if (!oldop)
                    num1 += key;
                else
                    num2 += key;

                resField.appendText(String.valueOf(key));

        }
        //System.out.println(oldop + "\t" + oldeq + "\t" + num1 + "\t\t" + num2 + "\t" + res);
        //oldkey = touches[fI][fJ];
        oldkey = key;
    }


    public double calc (String n1 , String n2 , String op) {
        //n1 = n1.split("\\.")[0];
        //n2 = n2.split("\\.")[0];
        switch (op) {
            case "+":
                return Double.parseDouble(n1) + Double.parseDouble(n2);
            case "-":
                return Double.parseDouble(n1) - Double.parseDouble(n2);
            case "x":
                return Double.parseDouble(n1) * Double.parseDouble(n2);
            case "/":
                return Double.parseDouble(n1) / Double.parseDouble(n2);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}