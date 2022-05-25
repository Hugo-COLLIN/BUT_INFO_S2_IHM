package com.example.td5_cercle_binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Scene
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 300);

        //Top
        // >Element creation
        Slider sTop = new Slider(0, 100, 20);
        sTop.setShowTickMarks(true);
        sTop.setShowTickLabels(true);
        //sTop.setBlockIncrement(0.2f);

        // >Add to pane
        root.setTop(sTop);

        //Center
        // >Element creation
        StackPane mainView = new StackPane();

        Circle circle = new Circle(0, 0, 20);
        circle.setFill(Color.RED);

        Label showCircleRadius = new Label();

        // >Add to pane
        mainView.getChildren().addAll(circle, showCircleRadius);
        root.setCenter(mainView);


        //Bottom
        // >Elements creation
        Slider sBottom = new Slider(0, 100, 20);
        sBottom.setShowTickMarks(true);
        sBottom.setShowTickLabels(true);
        //sBottom.setBlockIncrement(0.2f);

        // >Add to pane
        root.setBottom(sBottom);


        //Events : Bindings
        // >Sliders sync
        sTop.valueProperty().bindBidirectional(sBottom.valueProperty());

        // >Circle radius change
        DoubleProperty radiusProp = circle.radiusProperty();
        DoubleProperty sliderProp = sTop.valueProperty();
        radiusProp.bind(sliderProp);

        // >Label's value change
        showCircleRadius.textProperty().bind(circle.radiusProperty().asString("%.2f")); //




        stage.setTitle("Circle + Binding - Hugo COLLIN");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}