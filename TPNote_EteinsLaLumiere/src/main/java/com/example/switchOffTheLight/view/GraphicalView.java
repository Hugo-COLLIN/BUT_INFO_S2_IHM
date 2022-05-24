package com.example.switchOffTheLight.view;

import com.example.switchOffTheLight.model.Grid;
import javafx.scene.layout.BorderPane;

public class GraphicalView extends BorderPane
{
    //Attributes
    Grid model;
    MainView lights;

    //Constructor
    public GraphicalView ()
    {
        this.model = new Grid();
        this.lights = new MainView();
        this.setCenter(this.lights);
    }


}
