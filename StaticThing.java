package com.example.newrunner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    protected double x;
    protected double y;
    protected double sizeX,sizeY;
    private double value;

    protected ImageView imageView;

    public StaticThing (double x, double y,double sizeX, double sizeY, String fileName, double value){
        this.x = x;
        this.y = y;
        Image imageViewSheet = new Image(fileName);
        this.imageView = new ImageView(imageViewSheet);
        this.imageView.setX(x);
        this.imageView.setY(y);
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.value = value; //paramètre pour les vies mais pas encore fait
    }

    public ImageView getImageView() {
        return imageView;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
