package com.example.switchOffTheLight._main;

import com.example.switchOffTheLight.model.Grid;
import com.example.switchOffTheLight.view.GraphicalView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Grid model = new Grid();
        GraphicalView vue = new GraphicalView();
        Scene scene = new Scene(vue);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}