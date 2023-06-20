import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CVEChecker {
    public static void main(String[] args) {
        // Application names and versions
        String[][] applications = {
                {"App1", "1.0"},
                {"App2", "2.3"},
                // Add more applications as needed
        };

        for (String[] app : applications) {
            String appName = app[0];
            String appVersion = app[1];

            try {
                HttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://cve.api.example.com/search?app=" + appName + "&version=" + appVersion);
                HttpResponse response = httpClient.execute(request);

                if (response.getStatusLine().getStatusCode() == 200) {
                    String responseBody = EntityUtils.toString(response.getEntity());
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
}
