package gameObjects;

import Backgrounds.Graphics.Assets;

import java.awt.image.BufferedImage;

public enum meteorSize {

    BIG(2,Assets.bigs), MED(2, Assets.smalls), SMALL(2, Assets.smalls), TINY(0, null);

    public int quantity;

    public BufferedImage[] textures;

    private meteorSize(int quantity, BufferedImage[] textures){
        this.quantity = quantity;
        this.textures = textures;
    }
}
