package com.scanner.standalone;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("DisplayVersion")
    private String displayVersion;
    @JsonProperty("InstallDate")
    private String installDate;

    // Constructors, getters and setters
    // ...

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayVersion() {
        return displayVersion;
    }

    public void setDisplayVersion(String displayVersion) {
        this.displayVersion = displayVersion;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }
}
