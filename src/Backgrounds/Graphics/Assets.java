package Backgrounds.Graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player;

    public static BufferedImage speed;

    public static BufferedImage blueLaser, greenLaser, redLaser;

    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds= new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    public static BufferedImage meteors;

    public static void init(){

        player = Loader.ImageLoader("/Backgrounds/Graphics/resources/player.png");
        speed = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Effects/fire08.png");
        blueLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserBlue01.png");
        greenLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserGreen11.png");
        redLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserRed01.png");
        redLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserRed01.png");
        redLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserRed01.png");
        redLaser = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Lasers/laserRed01.png");



        for(int i = 0; i < bigs.length; i++)
            bigs[i] = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Meteors/meteorGreyBig"+(i+1)+".png");

        for(int i = 0; i < meds.length; i++)
            meds[i] = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Meteors/meteorGreyMed"+(i+1)+".png");

        for(int i = 0; i < smalls.length; i++)
            smalls[i] = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Meteors/meteorGreySmall"+(i+1)+".png");

        for(int i = 0; i < tinies.length; i++)
            tinies[i] = Loader.ImageLoader("/Backgrounds/Graphics/resources/resourcesSkins/PNG/Meteors/meteorGreyTiny"+(i+1)+".png");

    }



}
