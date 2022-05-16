package com.example.td4_serpent_mvc.modele;

import java.util.Objects;

public class Position
{
    //Attributes
    private int x,y;

    //Constructor
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Redefiniton de equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

}
