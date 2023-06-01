package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DashboardController {

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
    void switchToScan() {
        Coordinator.stage.setScene(Coordinator.scanScene);
    }
    @FXML
    void switchToHistory() {
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
    @FXML
    void switchToSideBar() {
        Coordinator.stage.setScene(Coordinator.sideBarScene);
    }
    @FXML
    void switchToDash() {
        Coordinator.stage.setScene(Coordinator.dashScene);
    }
}
