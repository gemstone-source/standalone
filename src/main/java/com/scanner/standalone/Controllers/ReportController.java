package com.scanner.standalone.Controllers;

import com.scanner.standalone.Apps;
import com.scanner.standalone.Coordinator;
import com.scanner.standalone.Data;
import com.scanner.standalone.Results;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

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
    private VBox rank;

    @FXML
    private FontAwesomeIconView sidebutton;
    @FXML

    private AnchorPane pane4;
    @FXML

    private VBox side;

    @FXML
    private VBox  vulnerabilitiesFound;
    @FXML
    void switchToHistory() {
        Coordinator.stage.setScene(Coordinator.historyScene);
    }
    @FXML
    void switchToDash() {
        Coordinator.stage.setScene(Coordinator.dashScene);
    }
    @Override
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
        pane4.setOnMouseClicked(event -> {


            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), side);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                side.setVisible(false);
            });
        });

        // Loop for loading dynamic applications
        try {
            List<Results> data = results();
            for(int i=0; i< data.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();

                // Found Vulnerability Pane
                fxmlLoader.setLocation(getClass().getResource("/com/scanner/standalone/fxml/vuln_list.fxml"));

                HBox hbox = fxmlLoader.load();
                ResultListController controller = fxmlLoader.getController();
                controller.setData(data.get(i));
                vulnerabilitiesFound.getChildren().add(hbox);

                // CVE Description Pane
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("/com/scanner/standalone/fxml/cve_list.fxml"));

                VBox vbox = fxmlLoader1.load();
                RankListController controller1 = fxmlLoader1.getController();
                controller1.setData(data.get(i));
                rank.getChildren().add(vbox);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Results> results() throws IOException {
        Apps apps = new Apps();

        List<Results> result1 = apps.test();

        return result1;
    }
}