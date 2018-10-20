package gameObjects;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import math.twoDVector;
import states.GameState;

public abstract class MovingObject extends GameObject {

    protected twoDVector velocity;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;
    protected  int width;
    protected  int height;


    public MovingObject(twoDVector position, twoDVector velocity, double maxVel, BufferedImage texture, GameState gameState){
        super(position,texture);
        this.velocity = velocity;
        this.maxVel = maxVel;
        width = texture.getWidth();
        height = texture.getHeight();
        angle=0;


    }
}
