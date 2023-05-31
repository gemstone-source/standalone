package com.scanner.standalone.Contollers;

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

    void switchToScan() {
        Coordinator.stage.setScene(Coordinator.scanScene);
    }

}

