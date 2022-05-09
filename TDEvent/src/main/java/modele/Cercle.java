package modele;

public class Cercle
{
    //Attributes
    private int x, y;
    private int limiteX, limiteY;

    //Constructors
    public Cercle()
    {
        this.x = 0;
        this.y = 0;
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

    public void to(String dir, int side)
    {
        switch (dir)
        {
            case "UP":
                if (this.y >= 0)
                    this.y -= side;
                break;
            case "DOWN":
                if (this.y <= limiteY)
                    this.y += side;
                break;
            case "LEFT":
                if (this.x >= 0)
                    this.x -= side;
                break;
            case "RIGHT":
                if (this.y <= limiteY)
                    this.x += side;
                break;
            default:
                break;
        }
    }

}
