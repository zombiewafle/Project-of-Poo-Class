import Backgrounds.Graphics.Assets;
import states.GameState;
import userShip.KeyboardController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;


public class GameTitle extends JFrame implements Runnable{

    public static final int WIDTH = 900, HEIGHT =700;
    private Canvas canvas;
    private Thread thread;
    private Boolean running=false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 60;
    private double TargetTime = 1000000000/FPS;
    private double delta = 0;
    private int averageFPS = FPS;
    private GameState gameState;
    private KeyboardController keyboardController;

    public GameTitle(){
        setTitle("GALAGA POO PROYECT GAME Version 02");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        keyboardController = new KeyboardController();

        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyboardController);

    }

    public static void main(String[] args){
        new GameTitle().start();
    }
    private void update(){
        keyboardController.update();
        gameState.update();
    }
    private void draw(){
        bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //-------------------------------

        g.setColor(Color.BLACK);

        g.fillRect(0,0,WIDTH,HEIGHT);

        gameState.draw(g);

        g.drawString(""+averageFPS,20,30);

        //--------------------------------------------

        g.dispose();
        bs.show();
    }

    private void init(){
        Assets.init();
        gameState = new GameState();

    }


    @Override
    public void run() {

        long nowTime = 0;
        long lasTime = System.nanoTime();
        long frames = 0;
        long time = 0;
        init();

        while(running){

            nowTime =System.nanoTime();
            delta += (nowTime - lasTime)/TargetTime;
            time += (nowTime - lasTime);
            lasTime = nowTime;

            if (delta >= 1);{
                update();
                draw();
                delta --;
                frames ++;
            }

            if(frames >= 1000000000){
                averageFPS = (int) frames;
                frames = 0;
                time = 0;
            }
        }
        stop();
    }

    private void start(){
        thread = new Thread(this);
        thread.start();
        running=true;

    }

    private void stop(){
        try {
            thread.join();
            running=false;
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
