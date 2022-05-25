package com.example.switchOffTheLight.controller;

import com.example.switchOffTheLight.model.GridModel;
import com.example.switchOffTheLight.view.GraphicalView;
import com.example.switchOffTheLight.view.GridView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickOnGridController implements EventHandler<MouseEvent>
{
    private final GridModel model;
    private final GraphicalView vue;

    public ClickOnGridController (GridModel m, GraphicalView v)
    {
        this.model = m;
        this.vue = v;
    }

    @Override
    public void handle(MouseEvent e) {
        if (e.isPrimaryButtonDown()) {
            this.model.clickOnLight((int) (e.getX() / GridView.TAILLE_CASE), (int) (e.getY() / GridView.TAILLE_CASE));
            System.out.println(e.getX() + "\n" + e.getY());
            this.vue.getGridView().update();
        }
    }
}
