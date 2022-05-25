package com.example.switchOffTheLight.controller;

import com.example.switchOffTheLight.model.Grid;
import com.example.switchOffTheLight.view.GraphicalView;
import com.example.switchOffTheLight.view.GridView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickOnGridController implements EventHandler<MouseEvent>
{
    private Grid model;
    private GridView vue;

    public ClickOnGridController (Grid m, GridView v)
    {
        this.model = m;
        this.vue = v;
    }

    @Override
    public void handle(MouseEvent e) {
        if (e.isPrimaryButtonDown()) {
            this.model.clickOnLight((int) (e.getX() / GridView.TAILLE_CASE), (int) (e.getY() / GridView.TAILLE_CASE));
            //this.vue.updateRectFill();
        }
    }
}
