package projectiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Bullet extends MovingGameObject{
    int diameter;
    int yVelocity;
    private Color color;
    private int xPos;
    private int yPos;

    public Bullet(int xPosition, int yPosition, int diameter, Color color){
        super(xPosition, yPosition,0, 0, color);
        this.diameter = diameter;
    }
    public int getDiameter(){
        return diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(this.getXPosition(), this.getYPosition(), 7, 15);

    }

    @Override
    public Rectangle getBounds() {
        Rectangle bulletHitbox = new Rectangle(xPos, yPos, 7, 15);
        return bulletHitbox;
    }

    @Override
    protected int getXPosition() {
        return 0;
    }

    @Override
    protected int getYPosition() {
        return 0;
    }
}
