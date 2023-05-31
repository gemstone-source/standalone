package com.scanner.standalone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FromJson {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("../jsonfile/apps.json");

        Object obj = jsonParser.parse(reader);
        JSONArray jsonArray = (JSONArray) obj;

        for (Object o : jsonArray) {
            JSONObject app = (JSONObject) o;

            String name = (String) app.get("DisplayName");
            String version = (String) app.get("DisplayVersion");
            String date = (String) app.get("InstallDate");

            System.out.println("Application Name: " + name);
            System.out.println("Application Version: " + version);
            System.out.println("Application Installed Date: " + date);
            System.out.println();
        }
    }
}
