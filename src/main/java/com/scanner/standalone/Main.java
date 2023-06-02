package com.scanner.standalone;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Coordinator.stage = stage;

        new Coordinator();

        stage.setTitle("Windows Vulnerability Scanner");
        //stage.setFullScreen(true);
        stage.setScene(Coordinator.dashScene);
        //stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}