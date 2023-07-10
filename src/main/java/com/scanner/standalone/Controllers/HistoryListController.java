package com.scanner.standalone.Controllers;
import com.scanner.standalone.Data;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class HistoryListController implements Initializable {
    @FXML
    private Text day;

    @FXML
    private Text time;
    @FXML
    private Text report_name;
    @FXML
    private HBox hbox;

    public void setData(String name){
        String[] parts = date_time(name);
        time.setText(parts[1]);
        day.setText(parts[0]);
        report_name.setText(name);

    }
    public  String[] date_time(String name) {

        // Remove the ".txt" extension
        String dateTimeString = name.replace(".txt", "");

        // Remove the "Report_" prefix
        String dateTimeWithoutPrefix = dateTimeString.replace("Report_", "");

        // Separate date and time

        return dateTimeWithoutPrefix.split("_");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hbox.setOnMouseClicked(event -> {
            File filePath = new File("src/main/resources/com/scanner/standalone/history/"+report_name.getText());
            try {
                Process process = Runtime.getRuntime().exec("powershell notepad.exe "+ filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
