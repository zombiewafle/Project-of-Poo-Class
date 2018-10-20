package gameObjects;

import math.twoDVector;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected BufferedImage texture;
    protected twoDVector position;

    public GameObject(twoDVector position, BufferedImage texture){

        this.position = position;
        this.texture = texture;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public twoDVector getPosition() {
        return position;
    }

    public void setPosition(twoDVector position) {
        this.position = position;
    }
}
