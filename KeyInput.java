import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    private boolean W;
    private boolean A;
    private boolean S;
    private boolean D;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    public KeyInput(Handler handler)
    {
        this.handler = handler;
        W = false;
        A = false;
        S = false;
        D = false;
        up = false;
        left = false;
        right = false;
        down = false;
    }
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++)
        {
            GameObject temp = handler.object.get(i);

            if(temp.getId() == ID.Player)
            {
                if(key == KeyEvent.VK_W && !S)
                {
                    W = true;
                    S = false;
                    A = false;
                    D = false;
                    temp.setVelY(-30);
                    temp.setVelX(0);
                }
                else if(key == KeyEvent.VK_A && !D)
                {
                    A = true;
                    D = false;
                    S = false;
                    W = false;
                    temp.setVelX(-30);
                    temp.setVelY(0);

                }
                else if(key == KeyEvent.VK_S && !W)
                {
                    S = true;
                    W = false;
                    A = false;
                    D = false;
                    temp.setVelY(30);
                    temp.setVelX(0);
                }
                else if(key == KeyEvent.VK_D && !A)
                {
                    D = true;
                    A = false;
                    S = false;
                    W = false;
                    temp.setVelX(30);
                    temp.setVelY(0);
                }

            }
            if(temp.getId() == ID.Player2)
            {
                if(key == KeyEvent.VK_UP && !down)
                {
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                    temp.setVelY(-30);
                    temp.setVelX(0);
                }
                else if(key == KeyEvent.VK_RIGHT && !left)
                {
                    right = true;
                    down = false;
                    left = false;
                    up = false;
                    temp.setVelX(30);
                    temp.setVelY(0);                }
                else if(key == KeyEvent.VK_DOWN && !up)
                {
                    down = true;
                    up = false;
                    left = false;
                    right = false;
                    temp.setVelY(30);
                    temp.setVelX(0);
                }
                else if(key == KeyEvent.VK_LEFT && !right)
                {
                    left = true;
                    down = false;
                    up = false;
                    right = false;
                    temp.setVelX(-30);
                    temp.setVelY(0);
                }
            }
        }

    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
      /*  for(int i = 0; i < handler.object.size(); i++) {
            GameObject temp = handler.object.get(i);

            if (temp.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    temp.setVelY(0);
                } else if (key == KeyEvent.VK_A) {
                    temp.setVelX(0);
                } else if (key == KeyEvent.VK_S) {
                    temp.setVelY(0);


                } else if (key == KeyEvent.VK_D) {
                    temp.setVelX(0);
                }

            }
        }*/
    }

}
