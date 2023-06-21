package com.scanner.standalone;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Apps {
    private Map<String, List<Results>> cache = new ConcurrentHashMap<>();

    public List<Results> test(Data[] apps) {
        SearchVulnerability search = new SearchVulnerability();
        File dir = new File("C:\\users\\hashghost\\Desktop\\4xxx");
        ExecutorService executor = Executors.newFixedThreadPool(12); // Use 12 Threads
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        List<Results> resultsList = new ArrayList<>(); // Local variable for storing results

        for (Data app : apps) {
            if (app.getDisplayName() != null && app.getDisplayVersion() != null) {
                String appName = app.getDisplayName();
                String appVersion = app.getDisplayVersion();
                String cacheKey = generateCacheKey(appName, appVersion);

                executor.execute(() -> {
                    List<Results> cachedResults = cache.get(cacheKey);
                    if (cachedResults != null) {
                        resultsList.addAll(cachedResults);
                    } else {
                        List<Results> results = search.showFiles(dir.listFiles(), appName, appVersion);
                        cache.put(cacheKey, results);
                        resultsList.addAll(results);
                    }
                });
            }
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // Wait for all tasks to complete
        }

        System.out.println("All applications scanned successfully.");
        return resultsList;
    }

    private String generateCacheKey(String appName, String appVersion) {
        return appName + "_" + appVersion;
    }
}



//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Apps {
// private Map<String, List<Results>> cache = new HashMap<>();
//
// public List<Results> test(Data[] apps) {
// SearchVulnerability search = new SearchVulnerability();
// File dir = new File("C:\\users\\hashghost\\Desktop\\4xxx");
// ExecutorService executor = Executors.newFixedThreadPool(12); // Use 12 Threads
//
// List<Results> resultsList = new ArrayList<>(); // Local variable for storing results
//
// for (Data app : apps) {
// if (app.getDisplayName() != null && app.getDisplayVersion() != null) {
// String appName = app.getDisplayName();
// String appVersion = app.getDisplayVersion();
// String cacheKey = generateCacheKey(appName, appVersion);
//
// executor.execute(() -> {
// List<Results> cachedResults;
// synchronized (cache) {
// cachedResults = cache.get(cacheKey);
// }
// if (cachedResults != null) {
// synchronized (resultsList) {
// resultsList.addAll(cachedResults);
// }
// } else {
// List<Results> results = search.showFiles(dir.listFiles(), appName, appVersion);
// synchronized (cache) {
// cache.put(cacheKey, results);
// }
// synchronized (resultsList) {
// resultsList.addAll(results);
// }
// }
// });
// }
// }
//
// executor.shutdown();
//
// while (!executor.isTerminated()) {
// // Wait for all tasks to complete
// }
//
// System.out.println("All applications scanned successfully.");
// return resultsList;
// }
//
// private String generateCacheKey(String appName, String appVersion) {
// return appName + "_" + appVersion;
// }
//}

//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Apps {
//    private List<Results> resultsList = new ArrayList<>();
//
//    public List<Results> test(Data[] apps) {
//        SearchVulnerability search = new SearchVulnerability();
//        File dir = new File("C:\\users\\hashghost\\Desktop\\4xxx");
//        ExecutorService executor = Executors.newFixedThreadPool(12); // Use 12 Threads
//
//        // Prepare a list of files to be scanned
//        List<File> filesToScan = new ArrayList<>();
//        collectFilesToScan(dir, filesToScan);
//
//        for (Data app : apps) {
//            if (app.getDisplayName() != null && app.getDisplayVersion() != null) {
//                String appName = app.getDisplayName();
//                String appVersion = app.getDisplayVersion();
//
//                executor.execute(() -> {
//                    List<Results> appResults = new ArrayList<>();
//                    for (File file : filesToScan) {
//                        appResults.addAll(search.showFiles(new File[]{file}, appName, appVersion));
//                    }
//                    synchronized (resultsList) {
//                        resultsList.addAll(appResults);
//                    }
//                });
//            }
//        }
//
//        executor.shutdown();
//
//        while (!executor.isTerminated()) {
//            // Wait for all tasks to complete
//        }
//
//        System.out.println("All applications scanned successfully.");
//        return resultsList;
//    }
//
//    private void collectFilesToScan(File dir, List<File> filesToScan) {
//        File[] files = dir.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (file.isDirectory()) {
//                    collectFilesToScan(file, filesToScan); // Recursively traverse directories
//                } else {
//                    filesToScan.add(file);
//                }
//            }
//        }
//    }
//}
