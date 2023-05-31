package com.scanner.standalone;

import java.io.IOException;

public class Fetch_applications {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("powershell \"$apps = Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName, DisplayVersion, InstallDate; ConvertTo-Json -InputObject @{'applications' = $apps} -Depth 100 | ForEach-Object { $_ -replace '^\\[\\d+,\\s*', '[' } | Out-File 'C:\\Users\\hashghost\\Desktop\\Final-Year-Project\\standalone\\src\\main\\resources\\jsonfile\\apps.json'\"\n \"");
            java.util.Scanner scanner = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            String result = scanner.hasNext() ? scanner.next() : "";
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
