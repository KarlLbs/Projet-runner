package com.example.newrunner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello World");
        Group root = new Group();
        //Pane pane = new Pane(root);
        //Scene theScene = new Scene(pane, 600, 400,true);
        //primaryStage.setScene(theScene);

        GameScene scene = new GameScene(root);
        //scene.setCamera();
        scene.render(scene.Cam);

        primaryStage.setScene(scene);

        primaryStage.show();
        //System.out.println((scene.Cam.toString()));
        scene.render(scene.Cam);

        //scene.hero.getSprite().setViewport(new Rectangle2D(75,0,85,100));
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {
                scene.hero.update(time);
                //camera.update(time);
                scene.update(time);
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
