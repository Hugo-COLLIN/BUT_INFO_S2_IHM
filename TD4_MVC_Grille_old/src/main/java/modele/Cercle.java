package modele;

public class Cercle
{
    //Attributes
    private int x, y;
    private final int limiteX = 10;
    private final int limiteY = 10;

    public Cercle(int x, int y)
    {
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
        this.x = x;
    }

    public void setY(int y) {
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
        if (this.y <= limiteY)
            this.x += 1;
    }

    /*

    public void to(String dir)
    {
        switch (dir)
        {
            case "UP":
                if (this.y >= 0)
                    this.y -= 1;
                break;
            case "DOWN":
                if (this.y <= limiteY)
                    this.y += 1;
                break;
            case "LEFT":
                if (this.x >= 0)
                    this.x -= 1;
                break;
            case "RIGHT":
                if (this.y <= limiteY)
                    this.x += 1;
                break;
            default:
                break;
        }
    }
     */
}