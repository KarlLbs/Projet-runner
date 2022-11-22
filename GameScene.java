package com.example.newrunner;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class GameScene extends Scene {
    private static StaticThing left;
    private static StaticThing right;
    private int slow=0;
    protected Group fond;
    protected Camera Cam;
    protected Hero hero;
    protected static StaticThing life;

    protected int nbLife;
    public GameScene(Group root){
        super(root);
        fond = root;
        Cam = new Camera(0,50,600,350);
        left = new StaticThing(0,0,800,400,"C:\\Users\\fakef\\Documents\\New runner\\img\\desert.png",0);
        right = new StaticThing(800,0,800,400,"C:\\Users\\fakef\\Documents\\New runner\\img\\desert.png",0);
        hero = new Hero("C:\\Users\\fakef\\Documents\\New runner\\img\\heros.png",100,200,0);
        life = new StaticThing(10,10,33,77,"C:\\Users\\fakef\\Documents\\New runner\\img\\life.png",3);

        //Label test = new Label(Cam.toString());

        root.getChildren().add(left.getImageView());
        root.getChildren().add(right.getImageView());
        root.getChildren().add(hero.getSprite());
        root.getChildren().add(life.getImageView());
        root.getChildren().get(3).setScaleX(1.5);
        root.getChildren().get(3).setScaleY(1.5);
        //root.getChildren().add(test);

    }
    public void render(Camera Cam){
        ((ImageView) fond.getChildren().get(0)).setViewport(new Rectangle2D(Cam.getX(),Cam.getY(),Cam.getWidthX(),Cam.getWidthY()));
        ((ImageView) fond.getChildren().get(1)).setX(right.sizeX - Cam.getX());
        ((ImageView) fond.getChildren().get(1)).setVisible(false);
        ((ImageView) fond.getChildren().get(3)).setViewport(new Rectangle2D(0,0,33,10));
        //((ImageView) fond.getChildren().get(3)).setVisible(true);


        if (Cam.getX()+ Cam.getWidthX() > left.sizeX ){
            ((ImageView) fond.getChildren().get(1)).setViewport(new Rectangle2D(0,Cam.getY(),Cam.getWidthX()-(right.sizeX- Cam.getX()),Cam.getWidthY()));
            ((ImageView) fond.getChildren().get(1)).setVisible(true);
        }
        if (Cam.getX()>= left.sizeX){
            Cam.setX(Cam.getX()-left.sizeX);
        }


    }

    public void update(long time){
        if (AnimatedThing.countFrame == AnimatedThing.maxFrame){
            Cam.setX(Cam.getX()+15);
            this.render(Cam);


            AnimatedThing.countFrame = 0;
        }
        else {
            AnimatedThing.countFrame+=1;
        }

    }
}
