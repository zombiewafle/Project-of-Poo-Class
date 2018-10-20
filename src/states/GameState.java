package states;

import Backgrounds.Graphics.Assets;
import gameObjects.*;
import math.twoDVector;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameState {

    private Player player;
    private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
    private int meteors;

    public GameState(){

        player = new Player(new twoDVector(400,300), new twoDVector(), 5, Assets.player, this);
        movingObjects.add(player);

        meteors = 1;

        startMeteorWave();
    }

    private void startMeteorWave(){
        double x, y;

        for(int i = 0; i <meteors; i++){
            x = i % 2 == 0 ? Math.random()*Constants.WIDTH: 0;

            y= i % 2 == 0 ? Math.random()*Constants.HEIGHT: 0;

            BufferedImage textures = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];

            movingObjects.add(new Meteor(
                    new twoDVector(x, y),
                    new twoDVector(0,1).setDirection(Math.random()*Math.PI*2),
                    Constants.METEOR_VEL*Math.random()+1,
                    textures,
                    this,
                    meteorSize.BIG
            ));
        }

        meteors ++;
    }

    public void update(){
        for(int i = 0; i < movingObjects.size( );i++)
            movingObjects.get(i).update();
    }
    public void draw(Graphics g){
        for(int i = 0; i < movingObjects.size( );i++)
            movingObjects.get(i).draw(g);
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }
}
