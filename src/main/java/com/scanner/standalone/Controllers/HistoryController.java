package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class HistoryController {

    @FXML
    private AnchorPane anc;

    @FXML
    private Pane pane;
    @FXML
    void switchToHistory() {
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
    @FXML
    void switchToDash() {
        Coordinator.stage.setScene(Coordinator.dashScene);
    }

}
