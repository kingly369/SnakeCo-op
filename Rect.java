public class Rect {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;

    public Rect(int x, int y, int sizeX, int sizeY)
    {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    public int getsizeX()
    {
        return this.sizeX;
    }

    public int getsizeY()
    {
        return this.sizeY;
    }
}
