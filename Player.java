import java.awt.*;


public class Player extends GameObject {
    private int sizeX;
    private int sizeY;
    private int spacing;
    private Handler handler;
    private boolean GameOver;

    public Player(int x, int y, ID id)
    {
        super(x,y,id);
        spacing = 50;
        sizeX = 20;
        sizeY = 20;

        if(this.getId() == ID.Tail || this.getId() == ID.Tail2) {
            velX = 0;
        }
        else
        {
            velX = 30;
        }
        velY = 0;
        handler = new Handler();
        GameOver = false;
    }


    public void tick()
    {
        if(x > 601) {
            velX = 0;
            GameOver = true;
            setX(600);

        }
        if(y>421)
        {
            velY = 0;
            GameOver = true;
            setY(420);
        }
        if(x<0)
        {
            velX = 0;
            GameOver = true;
            setX(1);
        }
        if(y<0)
        {
            velY = 0;
            GameOver = true;
            setY(1);
        }
            x += velX;
            y +=velY;


    }

    public boolean gameOver()
    {
        return GameOver;
    }

    public void render(Graphics g)
    {
        if(id == ID.Player || id == ID.Tail) {
            g.setColor(Color.white);
            g.fillRect(x,y,sizeX,sizeY);
        }
        else
        {
            g.setColor(Color.red);
            g.fillRect(x,y,sizeX,sizeY);
        }
      /*  for(int i =0 ; i < handler.getArray().size(); i++) {
            Rect a = handler.getArray().get(i);
            g.fillRect(a.getX(),a.getY(), a.getsizeX(), a.getsizeY());
        }
        */
     // g.fillRect(x,y,sizeX,sizeY);



    }
}
