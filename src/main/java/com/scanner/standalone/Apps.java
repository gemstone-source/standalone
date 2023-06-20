package com.scanner.standalone;

import com.scanner.standalone.Controllers.AppsController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Apps {

    List<Results> resultsList = new ArrayList<>();
    public List<Results> test(Data[] apps) {
        SearchVulnerability search = new SearchVulnerability();
        File dir = new File("~\\Desktop\\4xxx");
        // AppsController application = new AppsController();

        //Data[] apps = application.app_info();

        // Compare json files (apps.json and cve.json)
        for (Data app : apps) {
            if (app.getDisplayName() != null && app.getDisplayVersion() != null) {

                String appName = app.getDisplayName();
                String appVersion = app.getDisplayVersion();
                resultsList.addAll(search.showFiles(dir.listFiles(), appName,appVersion));
            }
        }

        return  resultsList;
    }
}