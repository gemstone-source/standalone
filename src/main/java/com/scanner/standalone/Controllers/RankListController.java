package com.scanner.standalone.Controllers;

import com.scanner.standalone.Data;
import com.scanner.standalone.Results;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RankListController implements Initializable {

    @FXML
    private Label cve;

    @FXML
    private Label description;


    public void setData(Results data){

        // CVE Pane
        description.setText(data.getDescription());
        cve.setText(data.getCveid());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}