package com.scanner.standalone;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.scanner.standalone.Controllers.AppsController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Fetch_applications {
    public  void fetch() {
        try {
            Process process = Runtime.getRuntime().exec("powershell \"Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName,DisplayVersion,InstallDate | Convertto-json |out-file '~\\Desktop\\Final-Year-Project\\standalone\\apps.json' \"");
            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            String result = scanner.hasNext() ? scanner.next() : "";
            System.out.println(result);

            //remove null values
            File filePath = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json");

            try {
                // Step 1: Read the JSON file and parse it into a JsonNode
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(new File(filePath.toURI()));

                // Step 2: Remove objects containing null values
                removeObjectsWithNullValues(rootNode);

                // Step 3: Write the updated JSON object back to the file
                ObjectWriter writer = objectMapper.writer().without(SerializationFeature.WRITE_NULL_MAP_VALUES);
                writer.writeValue(new File(filePath.toURI()), rootNode);

                System.out.println("Objects with null values removed successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void removeObjectsWithNullValues(JsonNode node) {
        if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                JsonNode element = node.get(i);
                if (element.hasNonNull("DisplayName") || element.hasNonNull("DisplayVersion") || element.hasNonNull("InstallDate")) {
                    removeObjectsWithNullValues(element);
                } else {
                    ((ArrayNode) node).remove(i);
                    i--; // Adjust the index to account for removed element
                }
            }
        }
    }
}
