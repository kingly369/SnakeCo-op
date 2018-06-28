import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    boolean running = false;
    private Handler handler;
    private int sleeper;


    public Game()
    {
        handler = new Handler();
        sleeper = 0;
        this.addKeyListener(new KeyInput(handler));
       Frame a = new Frame(WIDTH,HEIGHT,"Title", this);

       handler.addObject(new Player(0,0,ID.Player));
       handler.object.get(0).setVelX(30);
       handler.addObject(new Player(30,420,ID.Player2));
       handler.object.get(1).setVelX(30);
      // handler.addRect(new Rect(30,30,30,30));
     //   handler.addObject(new Player(500,500,ID.Tail));
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void sleep()
    {
        try
        {
            System.out.println("Sleeping start");
            thread.sleep(10000);
            System.out.println("Sleeping end");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void stop()
    {
        try{
            thread.join();
            running = false;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {

                tick();
                delta--;
            }
            if(running)
            {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }
        stop();
    }

    private void tick()
    {
        sleeper++;
        if(sleeper %10 ==0)
        {
            int ax = handler.object.getFirst().getX();
            int ay = handler.object.getFirst().getY();
          //  GameObject b = handler.object.getFirst();
          //  GameObject c = handler.object.get(1);
            int dx = handler.object.get(1).getX();
            int dy = handler.object.get(1).getY();
            handler.tick();

            GameObject a = new Player(ax,ay,ID.Tail);
            handler.addObject(a);

            GameObject d = new Player(dx,dy,ID.Tail2);
            handler.addObject(d);
            if(handler.gameOver())
            {
                running = false;
            }


        }

    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);
        g.dispose();
        bs.show();
    }

    public static void main (String[] args)
    {
        new Game();

    }
}
