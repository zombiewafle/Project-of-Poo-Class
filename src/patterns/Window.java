package patterns;

import score.Score;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JApplet implements MouseMotionListener {
    private BufferedImage image;
    private BufferedImage side;
    private int mouseX;
    private int mouseY;

    public Window(){
        try {
            image = ImageIO.read(new File("Backgraounds/violet.jpg"));
            side = ImageIO.read(new File("Backgrounds/side margin.jpg"));
        }catch (IOException ex){}
    }
    private void delay(int delay){
        try{
            Thread.sleep(delay);
        }catch (InterruptedException e){}
    }

    public void init(){
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics page){
        page.drawImage(image, 0, 0, null);
        page.setColor(Color.blue);
        page.fillRect(0, 0, 160, 160);
        page.setColor(Color.black);
        page.fillRect(15, 15, 130, 130);
        page.setColor(Color.green);
        page.fillRect(340, 0, 160, 160);
        page.setColor(Color.black);
        page.fillRect(355, 15, 130, 130);
        page.setColor(Color.yellow);
        page.fillRect(0, 340, 160, 160);
        page.setColor(Color.black);
        page.fillRect(15, 355, 130, 130);
        page.setColor(Color.red);
        page.fillRect(340, 340, 160, 160);
        page.setColor(Color.black);
        page.fillRect(355, 355, 130, 130);
        page.drawImage(side, 500, 0, null);
        page.drawString(Score.getScore(), 560, 110);
        //conveyors
        page.setColor(Color.gray);
        page.fillRect(235, 0, 30, 160);

        delay(100);

        page.fillOval(mouseX, mouseY, 40, 40);
    }
    public void mouseMoved(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
    public void mouseDragged(MouseEvent e){
    }
}
