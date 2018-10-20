
package projectiles;

import java.awt.*;

public abstract class MovingGameObject extends GameObject implements Moveable{
    int xVel;
    int yVel;
    private int yPos;
    private int xPos;
    private double maxVel;

    public MovingGameObject(int xPosition, int yPosition, int xVelocity, int yVelocity, Color color) {
        super(xPosition, yPosition, color);
        this.xVel = xVelocity;
        this.yVel = yVelocity;
    }

    public int getxVel() {
        return xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void setxVel(int xVel) {
        this.xVel = xVel;
    }

    public void setyVel(int yVel) {
        this.yVel = yVel;
    }
    @Override

    public void move(){
        this.xPos += xVel;
        this.yPos += yVel;
    }

    public abstract void draw(Graphics g);

    public abstract Rectangle getBounds();

    protected abstract int getXPosition();

    protected abstract int getYPosition();
}
