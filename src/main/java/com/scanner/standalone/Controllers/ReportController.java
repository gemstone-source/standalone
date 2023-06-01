package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ReportController {

    @FXML
    private Pane pane;

    @FXML
    private VBox pane1;

    @FXML
    private VBox pane11;

    @FXML
    private VBox pane111;

    @FXML
    private VBox pane12;
    @FXML
    void switchToHistory() {
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
    @FXML
    void switchToDash() {
        Coordinator.stage.setScene(Coordinator.dashScene);
    }
}

