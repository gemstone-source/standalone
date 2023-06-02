package com.scanner.standalone.Controllers;

import com.scanner.standalone.Coordinator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
        import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AppsController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private VBox pane11;

    @FXML
    private FontAwesomeIconView sidebutton;

    @FXML
    private AnchorPane pane6;

    @FXML
    private VBox side;
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
        pane6.setOnMouseClicked(event -> {


            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), side);
            fadeTransition1.setFromValue(0.5);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                side.setVisible(false);
            });
        });
    }
}
