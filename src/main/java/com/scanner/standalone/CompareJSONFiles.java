package com.scanner.standalone;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CompareJSONFiles {
    public static void main(String[] args) {
        File folder1 = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone");
        File folder2 = new File("C:\\Users\\hashghost\\Desktop\\cvelistV5-main\\cves\\2022\\4xxx");

        // Traverse through folder 1 and find all JSON files
        for (File file1 : folder1.listFiles()) {
            if (file1.getName().endsWith(".json")) {
                // Extract relevant fields from file1
                JSONObject json1 = extractFields(file1);

                // Traverse through folder 2 and find matching JSON file
                for (File file2 : folder2.listFiles()) {
                    if (file2.getName().endsWith(".json")) {
                        // Extract relevant fields from file2
                        JSONObject json2 = extractFields(file2);

                        // Compare relevant fields from file1 and file2
                        if (json1.get("DisplayName").equals(json2.get("product"))
                                || json1.get("DisplayName").equals(json2.get("product_name"))) {
                            // Do something if the relevant fields match
                            System.out.println("Found matching files: " + file1.getName() + ", " + file2.getName());
                        }
                    }
                }
            }
        }
    }

    public static JSONObject extractFields(File file) {
        JSONObject json = new JSONObject();
        try {
            FileReader reader = new FileReader(file);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            json = (JSONObject) obj;
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Extract relevant fields from the JSON object
        JSONObject extracted = new JSONObject();
       // extracted.put("vendor", ((JSONObject)json.get("containers")).get("affected"));
        extracted.put("product", ((JSONObject)((JSONObject)((JSONObject)json.get("containers")).get("cna")).get("affected")).get("product"));
        return extracted;
    }
}
