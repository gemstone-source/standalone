package com.scanner.standalone.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationsList implements Initializable {
    @FXML
    private Button app_action;

    @FXML
    private Label app_date;

    @FXML
    private Label app_name;

    @FXML
    private Label app_version;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
