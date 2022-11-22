package com.example.newrunner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double X,Y;

    private static Image spriteSheet;
    protected static ImageView sprite;
    //private int attitude;
    protected static int index;
    private long duration;
    protected static int maxIndex;
    //private int sizeWindow;
    protected static int offset;
    protected static int countFrame;
    protected static int maxFrame;
    private int jumpIndex=0;
    public static int jumpOk =0;
    public AnimatedThing(String fileName, int x, int y, int state){
        countFrame =0;
        maxFrame = 6;
        offset = 85;
        state = 0;
        maxIndex = 5;
        index = 0;
        spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,85,100));
        sprite.setX(x);
        sprite.setY(y);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public static void update(long time) {
        int newIndexJump;
        if (jumpOk == 0) {
            if (countFrame == maxFrame) {
                Hero.sprite.setViewport(new Rectangle2D((Hero.index) * Hero.offset, 0, 85, 100));
                if (Hero.index == Hero.maxIndex) {
                    Hero.index = 0;
                } else {
                    Hero.index += 1;
                }
                countFrame = 0;
            } else {
                countFrame += 1;
            }
        }
        else {


        }



    }


}
