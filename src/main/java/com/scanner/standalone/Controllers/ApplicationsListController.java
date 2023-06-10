package com.scanner.standalone.Controllers;

import com.scanner.standalone.Data;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
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

    public void setData(Data data){
        app_date.setText(data.getInstallDate());
        app_name.setText(data.getDisplayName());
        app_version.setText(data.getDisplayVersion());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
