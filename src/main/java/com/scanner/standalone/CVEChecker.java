package com.scanner.standalone;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CVEChecker {
    ObjectMapper mapper = new ObjectMapper();
    List<Results> outputs = new ArrayList<>();
    public List<Results> libraries() throws IOException {

        CVEChecker cveChecker = new CVEChecker();
        DependencyData[] dependencyData = cveChecker.dep_info();
        // Application names and versions


        for (DependencyData app : dependencyData) {
            String appName = cveChecker.getTrimmedString(app.getFileName());
            String appVersion = app.getProductVersion();
            System.out.println(encodeURLParameter(appName)+"%20"+encodeURLParameter(appVersion));

            try {
                HttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://services.nvd.nist.gov/rest/json/cves/1.0?keyword=" + encodeURLParameter(appName) + encodeURLParameter(appVersion));/*+ encodeURLParameter(appVersion)*/
                HttpResponse response = httpClient.execute(request);

                if (response.getStatusLine().getStatusCode() == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity());
                    System.out.println(responseBody);
                    outputs.addAll(cveChecker.retrieveData(responseBody,appName,appVersion));
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
        return outputs;
    }
    public List<Results> retrieveData(String output,String lib,String version2) {
        List<Results> tray1 = new ArrayList<>();
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

                    Results result = new Results();

                    // Vulnerability Found Pane Results
                    result.setItem(lib);
                    result.setSeverity(String.valueOf(version2));
                    result.setInstallDate(String.valueOf(LocalDate.now()));

                    // CVE Description(Rank) Pane
                    result.setCveid(cveId);
                    result.setDescription(descriptionValue);


                    tray1.add(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tray1;
    }

    public String appName(String item) {
        String[] words = item.trim().split("\\s+");
        String last = (words.length == 1) ? item : words[words.length - 1];
        last = last+".exe";
        return last;
    }

    public void getLibraries(String app) throws IOException {
        String scriptPath = "C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\com\\scanner\\standalone\\scripts\\cool.ps1";
        String[] command = {"powershell", "-File", scriptPath, app};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
     //   Process process = Runtime.getRuntime().exec("powershell C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\com\\scanner\\standalone\\scripts\\cool.ps1 "+app);
    }
    public DependencyData[] dep_info() throws IOException {
//        CVEChecker cveChecker = new CVEChecker();
//        cveChecker.getLibraries(cveChecker.appName(item));
        File jsonFile = new File("C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\dependancies.json");
        DependencyData[] depsData = mapper.readValue(jsonFile, DependencyData[].class);

        return depsData;
    }
    private String getTrimmedString(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf('\\') + 1); // Extracts the file name with extension
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, dotIndex).toLowerCase(); // Extracts the substring without extension
    }
    private static String encodeURLParameter(String parameter) {
        return URLEncoder.encode(parameter, StandardCharsets.UTF_8);
    }

}
