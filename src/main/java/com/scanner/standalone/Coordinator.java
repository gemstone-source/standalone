package com.scanner.standalone;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Coordinator {
    public static Stage stage;
    public static Scene dashScene;
    public static Scene reportScene;
    public static Scene scanScene;

    private void createDashScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/dashboard.fxml"));
        dashScene = new Scene(fxmlLoader.load());
    }

    private void createScanScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/scan.fxml"));
        scanScene = new Scene(fxmlLoader.load());
    }

    public Coordinator() throws IOException {
        createDashScene();
        createScanScene();
    }


}
