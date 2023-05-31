package com.scanner.standalone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FromJson {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\jsonfile\\apps.json");

        Object obj = jsonParser.parse(reader);
        JSONObject appobject = (JSONObject) obj;

        JSONArray array = (JSONArray) appobject.get("applications");

        for (int i = 0; i < array.size(); i++) {
            JSONObject application = (JSONObject) array.get(i);

            String name = (String) application.get("DisplayName");
            String version = (String) application.get("DisplayVersion");
            String date = (String) application.get("InstallDate");

            System.out.println("Application Name: " + name);
            System.out.println("Application Version: " + version);
            System.out.println("Application Installed Date: " + date);
            System.out.println();
        }
    }
}
