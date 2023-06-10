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
    public static Scene appScene;
    public static Scene historyScene;
    public static Scene sideBarScene;

    private void createDashScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/dashboard.fxml"));
        dashScene = new Scene(fxmlLoader.load(),1434.4,833.6);
    }
    private void createHistoryScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/history.fxml"));
        historyScene = new Scene(fxmlLoader.load(),1434.4,833.6);
    }

    private void createScanScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/scan.fxml"));
        scanScene = new Scene(fxmlLoader.load(),1434.4,833.6);
    }

    private void createAppScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/applications.fxml"));
        appScene = new Scene(fxmlLoader.load(),1434.4,833.6);
    }
    private void createReportScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/report.fxml"));
        reportScene = new Scene(fxmlLoader.load(),1434.4,833.6);
    }
    private void createSideBarScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/sideBar.fxml"));
        sideBarScene = new Scene(fxmlLoader.load());
    }

    public Coordinator() throws IOException {
        createDashScene();
        createScanScene();
        createAppScene();
        createReportScene();
        createHistoryScene();
        createSideBarScene();
    }


}
