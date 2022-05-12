package com.example.td4_1_grillemvc_frommodele.modele;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Cercle {
    //Attributes
    private int x;
    private int y;
    private final int limiteX = 10;
    private final int limiteY = 10;

    public Cercle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methods
    // >Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // >Setters
    public void setX(int x) {
        if (x >= 0 && x <= limiteX)
            this.x = x;
    }

    public void setY(int y) {
        if (y >= 0 && y <= limiteY)
            this.y = y;
    }


    public void up()
    {
        if (this.y >= 0)
            this.y -= 1;
    }

    public void down()
    {
        if (this.y <= limiteY)
            this.y += 1;
    }

    public void left()
    {
        if (this.x >= 0)
            this.x -= 1;
    }

    public void right()
    {
        if (this.y <= limiteX)
            this.x += 1;
    }


    public void to(KeyCode dir) {
        switch (dir) {
            case UP:
            case Z:
                if (this.y > 0)
                    this.y -= 1;
                break;
            case DOWN:
            case S:
                if (this.y < limiteY)
                    this.y += 1;
                break;
            case LEFT:
            case Q:
                if (this.x > 0)
                    this.x -= 1;
                break;
            case RIGHT:
            case D:
                if (this.x < limiteX)
                    this.x += 1;
                break;
            default:
                break;
        }
    }
}