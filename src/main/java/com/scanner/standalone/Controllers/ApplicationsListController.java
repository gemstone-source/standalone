package com.scanner.standalone.Controllers;

import com.scanner.standalone.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationsListController implements Initializable {
    @FXML
    private Button app_action;

    @FXML
    private Label app_date;

    @FXML
    private Label app_name;

    @FXML
    private Label app_version;
   public List<Results> result = new ArrayList<>();
   // UpdateData[] data = new UpdateData[1];

    public void setData(Data data){
        app_date.setText(data.getInstallDate());
        app_name.setText(data.getDisplayName());
        app_version.setText(data.getDisplayVersion());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void setApp_action() {
        Data updateData = new Data();
        updateData.setDisplayName(app_name.getText());
        updateData.setInstallDate(app_date.getText());
        updateData.setDisplayVersion(app_version.getText());
        Data[] data = new Data[1];
        data[0] = updateData;
        Apps apps = new Apps();
        result.addAll(apps.test(data));

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/scanner/standalone/fxml/report.fxml"));
                AnchorPane reportPane = fxmlLoader.load();

                // Access the ReportController
                ReportController reportController = fxmlLoader.getController();
                reportController.setData(result);

                // Create a new scene with the loaded FXML
                Scene reportScene = new Scene(reportPane);

                // Set the new scene on the stage
                Coordinator.stage.setScene(reportScene);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


}
