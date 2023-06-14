package com.scanner.standalone.Controllers;

import com.scanner.standalone.Data;
import com.scanner.standalone.Results;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultListController implements Initializable {

    @FXML
    private Label app_name;

    @FXML
    private Label date;

    @FXML
    private Label severity;

    public void setData(Results data){
        app_name.setText(data.getItem());
        date.setText(data.getInstallDate());
        severity.setText(data.getSeverity());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}