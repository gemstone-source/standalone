package com.scanner.standalone.Controllers;

import com.scanner.standalone.CVEChecker;
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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    @FXML
    private AnchorPane anc;

    @FXML
    private Pane pane;

    @FXML
    private FontAwesomeIconView sidebutton;
    @FXML

    private AnchorPane pane5;
    @FXML
    private VBox side;
    @FXML
    private VBox history_list;
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
        pane5.setOnMouseClicked(event -> {


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
            File files = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\com\\scanner\\standalone\\history");;
            for (File file : files.listFiles()){
                FXMLLoader fxmlLoader = new FXMLLoader();
              //  fxmlLoader.setLocation(getClass().getResource("com/scanner/standalone/fxml/history_list.fxml"));

                // Found Vulnerability Pane
                fxmlLoader.setLocation(getClass().getResource("/com/scanner/standalone/fxml/history_list.fxml"));

                VBox vbox = fxmlLoader.load();
                HistoryListController controller = fxmlLoader.getController();
                controller.setData(file.getName());


                history_list.getChildren().add(vbox);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
