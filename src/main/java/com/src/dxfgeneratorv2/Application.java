package com.src.dxfgeneratorv2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("style.css");
        stage.setTitle("DXFgenerator V2.0");
     //   stage.setWidth(scene.getWidth());
       // stage.setHeight(scene.getHeight());
       // stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*try {
            //File resource = new File(Thread.currentThread().getContextClassLoader().getResource("filename.ext").toURI());
            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/
        launch();
    }
}