package com.scanner.standalone;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CVEChecker {
    public static void main(String[] args) {
        // Application names and versions
        String[][] applications = {
                {"vlc", "3.0.11"},
                {"App2", "2.3"},
                // Add more applications as needed
        };

        for (String[] app : applications) {
            String appName = app[0];
            String appVersion = app[1];

            try {
                HttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://services.nvd.nist.gov/rest/json/cves/1.0?keyword=" + appName + "&version=" + appVersion);
                HttpResponse response = httpClient.execute(request);

                if (response.getStatusLine().getStatusCode() == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println(responseBody);
                    CVEChecker cveChecker = new CVEChecker();
                    cveChecker.retrieveData(responseBody);
                    // Parse the JSON response and extract the relevant information
                    // (application name, version, CVE ID, severity score)
                    // Update your code accordingly based on the structure of the API response
                    // You might need to use a JSON parsing library like Jackson or Gson

                    // Process the retrieved information as per your requirements (e.g., store in a data structure, display to the user)
                } else {
                    System.err.println("Error: API request failed with status code " + response.getStatusLine().getStatusCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void retrieveData(String output) {
        String json = output;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode cveItemsNode = rootNode.path("result").path("CVE_Items");
            if (cveItemsNode.isArray()) {
                for (JsonNode cveItemNode : cveItemsNode) {
                    JsonNode cveNode = cveItemNode.path("cve");
                    String cveId = cveNode.path("CVE_data_meta").path("ID").asText();

                    JsonNode descriptionNode = cveNode.path("description").path("description_data");
                    String descriptionValue = descriptionNode.path(0).path("value").asText();

                    System.out.println("CVE ID: " + cveId);
                    System.out.println("Description: " + descriptionValue);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String appName(String item) {
        String[] words = item.trim().split("\\s+");
        String last = (words.length == 1) ? item : words[words.length - 1];
        last = last+".exe";
        return last;
    }

    public void getLibraries(String app) throws IOException {
        Process process = Runtime.getRuntime().exec("powershell scripts/cool.ps1 vlc.exe  ");
    }

}
