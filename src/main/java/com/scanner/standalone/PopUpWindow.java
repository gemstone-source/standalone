package com.scanner.standalone;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String message = "Application or library is not vulnerable";

        // Create the label to display the message
        Label label = new Label(message);
        label.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Create the layout and add the label
        VBox layout = new VBox(100);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(label);

        // Create the pop-up window
        Stage popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.setTitle("Vulnerability Status");
        popUpStage.setMinWidth(550);
        popUpStage.setMinHeight(400);

        // Set the layout as the scene content
        Scene scene = new Scene(layout);
        popUpStage.setScene(scene);

        // Show the pop-up window
        popUpStage.showAndWait();
    }
}
