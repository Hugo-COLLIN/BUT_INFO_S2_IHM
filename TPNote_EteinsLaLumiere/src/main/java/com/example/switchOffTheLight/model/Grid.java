package com.example.switchOffTheLight.model;

public class Grid
{
    boolean [][] lights;

    public static final int LENGTH_X = 4;
    public static final int LENGTH_Y = 3;

    public Grid() {
        this.lights = new boolean[LENGTH_X][LENGTH_Y];

        for (int i = 0 ; i < LENGTH_X ; i ++)
            for (int j = 0 ; j < LENGTH_Y ; j ++)
                this.lights[i][j] = false;
    }

    public void invertOnClick (int x, int y)
    {
        invert(x,y);
        tryInvert(x - 1, y);
        tryInvert(x + 1, y);
        tryInvert(x, y - 1);
        tryInvert(x, y + 1);
    }

    public void tryInvert (int x, int y)
    {
        if (inGrid(x, y))
            invert(x, y);
    }

    public void invert (int x, int y)
    {
        this.lights[x][y] = !this.lights[x][y];
    }

    public boolean inGrid (int x, int y)
    {
        return x >= 0 && x < LENGTH_X && y >= 0 && y < LENGTH_Y;
    }

    //Getter
    public boolean getLight(int x, int y) {
        return this.lights[x][y];
    }
}
