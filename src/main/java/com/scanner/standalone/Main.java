package com.scanner.standalone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Coordinator.stage = stage;

        new Coordinator();

        //Changing the top icon picture
        Image icon = new Image("file: /icons/bars-solid.png");
        //stage.getIcons().add(new Image("file:icons/icon8-chrome-48.png"));
        stage.getIcons().add(icon);

        stage.setTitle("Windows Vulnerability Scanner");
        stage.setScene(Coordinator.dashScene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}