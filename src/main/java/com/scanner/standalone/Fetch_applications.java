package com.scanner.standalone;

import java.io.IOException;

public class Fetch_applications {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("powershell \"Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName,DisplayVersion,InstallDate | Convertto-json |out-file 'C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\apps.json' \"");
            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            String result = scanner.hasNext() ? scanner.next() : "";
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
