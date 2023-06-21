package com.scanner.standalone;


import com.fasterxml.jackson.annotation.JsonProperty;

public class DependencyData {
    @JsonProperty("FileName")
    private String fileName;
    @JsonProperty("ProductVersion")
    private String productVersion;

    // Constructors, getters and setters
    // ...

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

}
