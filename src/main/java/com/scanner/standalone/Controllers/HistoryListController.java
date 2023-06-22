package com.scanner.standalone.Controllers;
import com.scanner.standalone.Data;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HistoryListController {
    @FXML
    private Text day;

    @FXML
    private Text time;
    @FXML
    private Text report_name;

    public void setData(){
        time.setText(String.valueOf(LocalTime.now()));
        day.setText(String.valueOf(LocalDate.now()));
        report_name.setText("Report"+ LocalDateTime.now());

    }
}
