package com.example.switchOffTheLight.view;

import com.example.switchOffTheLight.model.Grid;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainView extends GridPane
{
    static final int TAILLE_CASE = 75;

    Grid model;


    public MainView()
    {
        this.model = new Grid();

        this.setHgap(5);
        this.setVgap(5);
        this.setPadding(new Insets(5));

        makeGridLigths();
    }

    public void makeGridLigths ()
    {
        for (int i = 0; i < Grid.LENGTH_X; i ++)
            for (int j = 0; j < Grid.LENGTH_Y; j ++)
                makeRect(i, j);
    }

    public void makeRect (int x, int y)
    {
        Rectangle rect = updateRectFill(
                new Rectangle( TAILLE_CASE, TAILLE_CASE),
                this.model.getLight(x,y)
        );
        rect.setArcHeight(15);
        rect.setArcWidth(15);
        this.add(rect, x, y);

    }

    public Rectangle updateRectFill (Rectangle rectP, boolean lightModel)
    {
        if (lightModel)
            rectP.setFill(Color.LIGHTGREEN);
        else
            rectP.setFill(Color.DARKGREEN);

        return rectP;
    }
}
