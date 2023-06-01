package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;

public class ScanController {
    @FXML
    private Button analyze;

    @FXML
    private AnchorPane anc;

    @FXML
    private Pane pane;

    @FXML
    private Button runscan;

    @FXML
    private Button updateDB;

    @FXML
    private Label welcomeText;

    @FXML
    protected void switchToApps() {
        Coordinator.stage.setScene(Coordinator.appScene);
    }
    @FXML
    protected void switchToReport() {
        Coordinator.stage.setScene(Coordinator.reportScene);
    }
    @FXML
    void switchToHistory() {
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
    @FXML
    void switchToDash() {
        Coordinator.stage.setScene(Coordinator.dashScene);
    }
}

