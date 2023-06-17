package com.scanner.standalone.Controllers;

import com.scanner.standalone.Apps;
import com.scanner.standalone.Coordinator;
import com.scanner.standalone.Results;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ScanController implements Initializable {
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
    private Button scan_multiple;

    @FXML
    private FontAwesomeIconView sidebutton;
    @FXML
    private AnchorPane pane3;
    @FXML
    private VBox side;

    @FXML
    private ReportController reportController;


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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        side.setVisible(false);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), side);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        sidebutton.setOnMouseClicked(event -> {


            side.setVisible(true);

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), side);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(1);
            fadeTransition1.play();
        });
        pane3.setOnMouseClicked(event -> {


            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), side);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                side.setVisible(false);
            });
        });
    }
    @FXML
    void loadReportController() {
        Apps apps = new Apps();
        AppsController appsController = new AppsController();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/scanner/standalone/fxml/report.fxml"));
            AnchorPane reportPane = fxmlLoader.load();

            // Access the ReportController
           ReportController reportController = fxmlLoader.getController();
            reportController.setData(apps.test(appsController.app_info()));

            // Create a new scene with the loaded FXML
            Scene reportScene = new Scene(reportPane);

            // Set the new scene on the stage
            Coordinator.stage.setScene(reportScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

