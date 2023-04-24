package com.scanner.standalone;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Apps {
    public static void main(String[] args) {
        SearchVulnerability search = new SearchVulnerability();
        File dir = new File("C:\\Users\\hashghost\\Desktop\\4xxx");
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file from the local directory
            File jsonFile = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json");

            // Map the JSON to a Java object
            Data[] apps = mapper.readValue(jsonFile, Data[].class);

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