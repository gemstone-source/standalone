package com.scanner.standalone.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scanner.standalone.Apps;
import com.scanner.standalone.Coordinator;
import com.scanner.standalone.Data;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AppsController implements Initializable {
    ObjectMapper mapper = new ObjectMapper();

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

        // Loop for loading dynamic applications
        try {
            Data[] data = app_info();
            for(int i=0; i< data.length; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/scanner/standalone/fxml/app_list.fxml"));

                HBox hbox = fxmlLoader.load();
                ApplicationsListController controller = fxmlLoader.getController();
                controller.setData(data[i]);

                pane11.getChildren().add(hbox);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Declaration of json file which stores user applications.
    public Data[] app_info() throws IOException {
        File jsonFile = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json");
        Data[] apps = mapper.readValue(jsonFile, Data[].class);

        return apps;
    }
}
