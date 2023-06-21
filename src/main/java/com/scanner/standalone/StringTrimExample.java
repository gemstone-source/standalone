package com.scanner.standalone;

public class StringTrimExample {
    public static void main(String[] args) {
        String filePath = "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe";
        String trimmedString = getTrimmedString(filePath);
        System.out.println(trimmedString);
    }

    private static String getTrimmedString(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf('\\') + 1); // Extracts the file name with extension
        int dotIndex = fileName.lastIndexOf('.');
        return fileName.substring(0, dotIndex); // Extracts the substring without extension
    }
}



