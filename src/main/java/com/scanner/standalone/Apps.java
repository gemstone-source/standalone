package com.scanner.standalone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scanner.standalone.Controllers.AppsController;

import java.io.File;
import java.io.IOException;

public class Apps {
    public static void main(String[] args) {
        SearchVulnerability search = new SearchVulnerability();
        File dir = new File("C:\\Users\\hashghost\\Desktop\\4xxx");
       // ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file from the local directory
           // File jsonFile = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json");

            // Map the JSON to a Java object
          //  Data[] apps = mapper.readValue(jsonFile, Data[].class);
            AppsController application = new AppsController();

            Data[] apps = application.app_info();

            // Compare json files (apps.json and cve.json)
            for (Data app : apps) {
                if (app.getDisplayName() != null && app.getDisplayVersion() != null) {
                   // System.out.println(app.getDisplayName());
                    String appName = app.getDisplayName();
                    String appVersion = app.getDisplayVersion();
                    search.showFiles(dir.listFiles(), appName,appVersion);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}