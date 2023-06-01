package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;

public class SideBarController implements Initializable {
    @FXML
    private VBox side;

    @FXML
    private FontAwesomeIconView homeIcon;

    @FXML
    private Label dasLabel;

    @FXML
    private Label feelSafeLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button homeButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button analyticsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up event handlers or initial properties of the UI components

        homeButton.setOnAction(e -> handleHomeButtonClick());
        inventoryButton.setOnAction(e -> handleInventoryButtonClick());
        analyticsButton.setOnAction(e -> handleAnalyticsButtonClick());
    }

    public void handleHomeButtonClick() {
        // Logic for handling the Home button click
        Coordinator.stage.setScene(Coordinator.dashScene);
    }

    public void handleInventoryButtonClick() {
        // Logic for handling the Inventory button click
        Coordinator.stage.setScene(Coordinator.scanScene);

    }

    public void handleAnalyticsButtonClick() {
        // Logic for handling the Analytics button click
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
}
