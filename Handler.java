import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    private ArrayList<Rect> array;
    public boolean gameOver;
    private int playerSize;
    private int player2Size;

    public Handler()
    {
        array = new ArrayList<Rect>();
        gameOver = false;
        playerSize = 1;
        player2Size = 1;
    }

    public void tick()
    {
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp = object.get(i);

                temp.tick();



        }
        //System.out.println(object.size());

    }

    public boolean gameOver()
    {
        if(object.size() >3) {
            for (int i = 2; i < object.size(); i++) {
                if(object.getFirst().getX() == object.get(object.size()-1).getX() && object.getFirst().getY() == object.get(object.size()-1).getY() && object.get(1).getX() == object.get(object.size()-2).getX() && object.get(1).getY() == object.get(object.size()-2).getY())
                {
                    System.out.println("Tie");
                    return true;
                }
                if (object.get(i).getX() == object.getFirst().getX() && object.get(i).getY() == object.getFirst().getY()) {
                    System.out.println("Red wins");
                    return true;
                }
                if(object.get(i).getX() == object.get(1).getX() && object.get(i).getY() == object.get(1).getY())
                {
                    System.out.println("White Wins");
                    return true;
                }

            }
        }
        if(object.getFirst().gameOver())
        {
            System.out.println("Red wins");
            return true;
        }
        if(object.get(1).gameOver())
        {
            System.out.println("White wins");
            return true;
        }
        return false;
    }
    public ArrayList<Rect> getArray()
    {
        return array;
    }

    public void addRect(Rect object)
    {
        array.add(object);
    }


    public void render(Graphics g)
    {
        for(int i = 0; i < object.size(); i++)
        {
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject object)
    {
     /*   if(player == ID.Tail)
        {
            this.object.add(playerSize,object);
           playerSize++;
        }
        if(player == ID.Tail2)
        {
            this.object.add(player2Size,object);
            player2Size =
        }
        */
     this.object.add(object);
    }

    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }
}
