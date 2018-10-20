package gameObjects;

import Backgrounds.Graphics.Assets;
import math.twoDVector;
import states.GameState;
import userShip.KeyboardController;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends MovingObject{

    private  twoDVector heading;
    private twoDVector acceleration;
    private final double ACC = 0.001;
    private boolean accelerating = false;
    private GameState gameState;
    private long time, lastTime;

    public Player(twoDVector position, twoDVector velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.gameState = gameState;
        heading = new twoDVector(0,1);
        acceleration = new twoDVector();
        time = 0;
        lastTime = System.currentTimeMillis();
    }

    @Override
    public void update() {

        time += System.currentTimeMillis() -1 - lastTime;
        lastTime = System.currentTimeMillis();

        if(KeyboardController.SHOOT && time > 90)
        {
            gameState.getMovingObjects().add(0, new Laser(
                    getCenter().add(heading.scale(width)),
                    heading,
                    10,
                    angle,
                    Assets.redLaser,
                    gameState));
            time = 0;
        }


        if (KeyboardController.RIGHT)
            angle += Math.PI / 250;

        if (KeyboardController.LEFT)
            angle -= Math.PI / 250;

        if (KeyboardController.UP) {

            acceleration = heading.scale(ACC);
            accelerating = true;
        } else {

            if (velocity.getMagnitude() != 0)
                acceleration = (velocity.scale(-1).normalize()).scale(ACC/2);
            accelerating = false;
        }

        velocity = velocity.add(acceleration);

        velocity.limit(maxVel);

        heading = heading.setDirection(angle - Math.PI / 2);


        position = position.add(velocity);

        /*
        if(position.getX() > Window.WIDTH)
            position.setX(0);
        if (position.getY() > Window.HEIGHT)
            position.setY(0);

        if(position.getX() < 0)
            position.setX(Window.WIDTH);
        if (position.getY() < 0)
            position.setY(Window.HEIGHT);

            */


    }
    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;

        AffineTransform at1 = AffineTransform.getTranslateInstance(position.getX() + width/2 +5,
                position.getY() + height/2 +10);

        AffineTransform at2 = AffineTransform.getTranslateInstance(position.getX()+5 ,
                position.getY() + height/2 +10);

        at1.rotate(angle, -5, -10);

        at2.rotate(angle,width/2 -5, -10);

        if(accelerating){

            graphics2D.drawImage(Assets.speed, at1, null);
            graphics2D.drawImage(Assets.speed, at2, null);
        }

        at = AffineTransform.getTranslateInstance(position.getX(),position.getY());

        at.rotate(angle, width/2, height/2);

        graphics2D.drawImage(texture,at,null);
    }

    public twoDVector getCenter(){
        return new twoDVector(position.getX() + width/2, position.getY() + height/2);
    }
}
