package com.scanner.standalone.Controllers;

import com.scanner.standalone.*;
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

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.HashSet;

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
    private VBox  alert;

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

    }
    public void setData(List<Results> data){
        List<Results> result = new ArrayList<>();
        result.addAll(data);
        try {
            HashSet<String> uniqueItems = new HashSet<>();
            HashSet<String> uniqueCVE = new HashSet<>();

            for(int i=0; i< data.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();

                // Found Vulnerability Pane
                fxmlLoader.setLocation(getClass().getResource("/com/scanner/standalone/fxml/vuln_list.fxml"));

                // CVE Description Pane
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("/com/scanner/standalone/fxml/cve_list.fxml"));


                //Alerts
                FXMLLoader fxmlLoader2 = new FXMLLoader();
                fxmlLoader2.setLocation(getClass().getResource("/com/scanner/standalone/fxml/alert_list.fxml"));

                if(uniqueCVE.add(data.get(i).getCveid())) {
                    //description
                    VBox vbox = fxmlLoader1.load();
                    RankListController controller1 = fxmlLoader1.getController();
                    controller1.setData(data.get(i));
                    rank.getChildren().add(vbox);

                    if (uniqueItems.add(data.get(i).getItem())) {
                        // Set only unique alert item with no duplicates
                        HBox alerts = fxmlLoader2.load();
                        AlertListController controller2 = fxmlLoader2.getController();
                        controller2.setData(data.get(i));
                        alert.getChildren().add(alerts);

                        //part of vulnerability found list
                        HBox hbox = fxmlLoader.load();
                        ResultListController controller = fxmlLoader.getController();
                        controller.setData(data.get(i));
                        vulnerabilitiesFound.getChildren().add(hbox);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Data received: " + result.get(0).getItem());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fileName = "C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\com\\scanner\\standalone\\history\\Report_" + now.format(formatter) + ".txt";
        saveResultsToFile(result,fileName);
        System.out.println("Results saved to results.txt");
        result.clear();
    }
    // Saving result to file
    public static void saveResultsToFile(List<Results> results, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Results result : results) {
                writer.write("Item: " + result.getItem() + "\n");
                writer.write("Install Date: " + result.getInstallDate() + "\n");
                writer.write("CVE ID: " + result.getCveid() + "\n");
                writer.write("Description: " + result.getDescription() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    List<Results> getData(){
//        return result;
//    }

}