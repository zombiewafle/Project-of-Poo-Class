package gameObjects;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.twoDVector;
import states.GameState;

public class Laser extends MovingObject{


    public Laser(twoDVector position, twoDVector velocity, double maxVel, double angle, BufferedImage texture, GameState gameState){
        super(position, velocity, maxVel, texture, gameState);
        this.angle = angle;
        this.velocity = velocity.scale(maxVel);

    }

    @Override
    public void update(){
        position = position.add(velocity);
    }

    @Override
    public void draw(Graphics g){

        Graphics2D g2d= (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());

        at.rotate(angle);

        g2d.drawImage(texture, at, null);
    }
}
