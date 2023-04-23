package com.scanner.standalone;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Apps {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read JSON file from the local directory
            File jsonFile = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json");

            // Map the JSON to a Java object
            Data[] apps = mapper.readValue(jsonFile, Data[].class);

            // Do something with the object
            for (Data app : apps) {
                System.out.println(app.getDisplayName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}