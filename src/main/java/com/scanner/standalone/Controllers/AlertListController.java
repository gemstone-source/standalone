package com.scanner.standalone.Controllers;

import com.scanner.standalone.Results;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AlertListController implements Initializable {

    @FXML
    private Label alertApp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setData(Results data){

        // CVE Pane
        alertApp.setText(data.getItem());
    }
}

