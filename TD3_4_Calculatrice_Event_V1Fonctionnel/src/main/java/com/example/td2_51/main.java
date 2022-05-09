package com.example.td2_51;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class main extends Application {
    String num1 ="";
    String num2 ="";
    String op ;
    double result= 0;
    boolean oldop =false ;
    // the GUI component
    public void start(Stage stage) throws Exception {
        Button one = new Button("1");
        Button two = new Button("2");
        Button pls = new Button("+");
        Button eql = new Button("=");
        Button ac = new Button("AC");
        Label lbl = new Label("empty");
        FlowPane pane = new FlowPane();
        pane.setHgap(10);
        pane.getChildren().addAll(one,two,pls,eql,ac,lbl);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        // The Actions on buttons
        one.setOnAction(e ->
        {
            if(!oldop){
                num1+='1';
                lbl.setText(num1);}
            else {
                num2+='1';
                lbl.setText(num2);}});

        two.setOnAction(e ->
        {
            if(!oldop){
                num1+='2';
                lbl.setText(num1);}
            else {
                num2+='2';
                lbl.setText(num2);}});

        pls.setOnAction(e -> {
            if(!oldop){
                oldop = true;
                op="+";
                lbl.setText(op);}
            else {
                result=calc(num1 , num2 ,op);
                num1=String.valueOf(result);
                num2="";
                op="+";
                lbl.setText(num1+op);
                oldop = true;}});

        eql.setOnAction(e ->{
            if(oldop){
                result=calc(num1 , num2 , op);
                lbl.setText(String.valueOf(result));
                oldop=false;
                num2="";}
            else
                return;});

        ac.setOnAction(e -> {
            num1="";
            num2="";
            result=0;
            oldop=false;});

    }
    // The calculation method
    public int calc (String n1 , String n2 , String op){
        n1=n1.split("\\.")[0];
        n2=n2.split("\\.")[0];
        switch (op) {
            case "+" :
                return Integer.parseInt(n1) + Integer.parseInt(n2) ;
            case "-" :
                return Integer.parseInt(n1) - Integer.parseInt(n2) ;
            case "*" :
                return Integer.parseInt(n1) * Integer.parseInt(n2) ;
            case "/" :
                return Integer.parseInt(n1) / Integer.parseInt(n2) ;
            default :
                return 0;
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}