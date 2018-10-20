package gameObjects;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Backgrounds.Graphics.Assets;
import math.twoDVector;
import states.GameState;

public class Meteor extends MovingObject{

    private meteorSize meteorSize;

    public Meteor(twoDVector position, twoDVector velocity, double maxVel, BufferedImage texture, GameState gameState, meteorSize meteorSize){
        super(position, velocity, maxVel, texture, gameState);
        this.meteorSize = meteorSize;
    }

    @Override
    public void update(){
        position = position.add(velocity);

        if(position.getX() > Constants.WIDTH)
            position.setX(0);
        if(position.getY() > Constants.HEIGHT)
            position.setY(0);

        if(position.getX() < 0)
            position.setX(Constants.WIDTH);
        if (position.getY() < 0)
            position.setY(Constants.HEIGHT);

        angle += Math.PI /2147483647;
    }
    @Override
    public void draw(Graphics g){

        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());

        at.rotate(angle, width/2, height/2);

        g2d.drawImage(texture,at,null);
    }

    public meteorSize getMeteorSize(){
        return meteorSize;
    }

}
